package org.example.service.impl;

import org.example.Constant;
import org.example.dao.DailyMapper;
import org.example.dao.FiveAvgMapper;
import org.example.dao.TenAvgMapper;
import org.example.entity.Daily;
import org.example.entity.FiveAvg;
import org.example.entity.TenAvg;
import org.example.service.AvgLineService;
import org.example.service.FiveAvgLineService;
import org.example.service.TenAvgLineService;
import org.example.utils.AlgorithmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AvgLineServiceImpl implements AvgLineService {
    @Autowired
    private FiveAvgMapper fiveAvgMapper;
    @Autowired
    private TenAvgMapper tenAvgMapper;
    @Autowired
    private DailyMapper dailyMapper;
    @Autowired
    private FiveAvgLineService fiveAvgLineService;
    @Autowired
    private TenAvgLineService tenAvgLineService;

    /**
     * 从上次更新的结束时间开始，将所有均线更新到现在
     *
     * @return 更新成功标志
     */
    @Override
    public boolean updateRecentAllAvgLine() {
        return updateRecentFiveAvgLine() && updateRecentTenAvgLine();
    }

    /**
     * 从上次更新5日均线开始，更新到现在
     *
     * @return 更新成功标志
     */
    @Override
    public boolean updateRecentFiveAvgLine() {
        Integer minDate = fiveAvgMapper.selectMinTradeDate();
        int begin = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, minDate);
        Integer startDate = Constant.TRADE_DAYS.get(begin + 1);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return updateFiveAvgLine(startDate, Integer.valueOf(dateFormat.format(date)));
    }

    /**
     * 更新指定日期的5日均线
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 更新成功标志
     */
    @Override
    public boolean updateFiveAvgLine(Integer beginDate, Integer endDate) {
        int begin = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, beginDate);
        int end = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, endDate);
        List<FiveAvg> res = new ArrayList<>();
        for (int index = begin; index <= end; index++) {
            Integer start = Constant.TRADE_DAYS.get(index - 4);
            Integer done = Constant.TRADE_DAYS.get(index);
            List<Daily> dailyList = dailyMapper.selectByTradeDate(start.toString(), done.toString());
            Map<String, BigDecimal> map = new HashMap<>();
            for (Daily daily : dailyList) {
                String key = daily.getTsCode();
                BigDecimal value = map.getOrDefault(key, new BigDecimal(0)).add(daily.getClose());
                map.put(key, value);
            }
            for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
                FiveAvg fiveAvg = new FiveAvg();
                fiveAvg.setTradeDate(done);
                fiveAvg.setTsCode(entry.getKey());
                fiveAvg.setFiveAvgClose(entry.getValue().divide(new BigDecimal(5)));
                res.add(fiveAvg);
            }
        }
        int flag = fiveAvgMapper.deleteByTradeDate(beginDate, endDate);
        return fiveAvgLineService.saveBatch(res);
    }

    /**
     * 从上次更新10日均线开始，更新到现在
     *
     * @return 更新成功标志
     */
    @Override
    public boolean updateRecentTenAvgLine() {
        Integer minDate = tenAvgMapper.selectMinTradeDate();
        int begin = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, minDate);
        Integer startDate = Constant.TRADE_DAYS.get(begin + 1);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return updateTenAvgLine(startDate, Integer.valueOf(dateFormat.format(date)));
    }

    /**
     * 更新指定日期的10日均线
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 更新成功标志
     */
    @Override
    public boolean updateTenAvgLine(Integer beginDate, Integer endDate) {
        int begin = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, beginDate);
        int end = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, endDate);
        List<TenAvg> res = new ArrayList<>();
        for (int index = begin; index <= end; index++) {
            Integer start = Constant.TRADE_DAYS.get(index - 9);
            Integer done = Constant.TRADE_DAYS.get(index);
            List<Daily> dailyList = dailyMapper.selectByTradeDate(start.toString(), done.toString());
            Map<String, BigDecimal> map = new HashMap<>();
            for (Daily daily : dailyList) {
                String key = daily.getTsCode();
                BigDecimal value = map.getOrDefault(key, new BigDecimal(0)).add(daily.getClose());
                map.put(key, value);
            }
            for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
                TenAvg tenAvg = new TenAvg();
                tenAvg.setTradeDate(done);
                tenAvg.setTsCode(entry.getKey());
                tenAvg.setTenAvgClose(entry.getValue().divide(new BigDecimal(10)));
                res.add(tenAvg);
            }
        }
        int flag = tenAvgMapper.deleteByTradeDate(beginDate, endDate);
        return tenAvgLineService.saveBatch(res);
    }
}
