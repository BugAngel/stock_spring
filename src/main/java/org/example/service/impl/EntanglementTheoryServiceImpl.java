package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.bean.StockDailyBasic;
import org.example.dao.DailyMapper;
import org.example.dao.StockDailyBasicMapper;
import org.example.entity.Daily;
import org.example.service.EntanglementTheoryService;
import org.example.utils.AlgorithmUtil;
import org.example.utils.StockUtil;
import org.example.utils.TradeDayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class EntanglementTheoryServiceImpl implements EntanglementTheoryService {
    @Autowired
    private DailyMapper dailyMapper;
    @Autowired
    private StockDailyBasicMapper stockDailyBasicMapper;

    /**
     * 大趋势上升,小趋势回调
     *
     * @param date     时间
     * @param range    时间范围
     * @param minSlope 拟合直线最小斜率
     * @param maxSlope 拟合直线最大斜率
     * @param callback 回调大小
     * @return 股票列表
     */
    @Override
    public List<StockDailyBasic> getRisingCorrectionList(Integer date, Integer range, Double minSlope, Double maxSlope, Double callback) {
        // 向前找,所以range用负数
        String begin = TradeDayUtil.getAddDate(date, -range).toString();
        String end = date.toString();
        log.info("上升回调查询开始时间 {},查询结束时间 {}", begin, end);
        List<Daily> dailyList = dailyMapper.selectByTradeDate(begin, end);
        Map<String, LinkedList<Daily>> stockDailyMap = StockUtil.dailyAggregateByStock(dailyList);
        log.info("上升回调查询股票数量 {}", stockDailyMap.size());
        Map<String, Double> stockDailyRangeMaxCloseMap = StockUtil.getStocksMaxClose(stockDailyMap);
        List<Integer> dailyIds = new ArrayList<>();

        for (Map.Entry<String, Double> entry : stockDailyRangeMaxCloseMap.entrySet()) {
            String tsCode = entry.getKey();
            double max = entry.getValue();
            double now = stockDailyMap.get(tsCode).getLast().getClose().doubleValue();
            // 1. 筛选回调符合要求的股票
            if ((max - now) / max >= callback) {
                // 2. 筛选符合斜率要求的股票
                LinkedList<Daily> callBackStockList = stockDailyMap.get(tsCode);
                double k = AlgorithmUtil.linerRegressionSlope(StockUtil.stockDailyClose2Double(callBackStockList));
                if (k >= minSlope && k <= maxSlope) {
                    // 筛选完成
                    dailyIds.add(stockDailyMap.get(tsCode).getLast().getId());
                }
            }
        }
        if (dailyIds.size() > 0) {
            log.info("上升回调股票数量 {}", dailyIds.size());
            return stockDailyBasicMapper.selectStockDailyBasicFromDailyIds(dailyIds);
        } else {
            return new ArrayList<>();
        }
    }
}
