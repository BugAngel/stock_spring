package org.example.service.impl;

import org.example.Constant;
import org.example.bean.StartStarInfo;
import org.example.bean.StockDailyBasic;
import org.example.bean.StockQuality;
import org.example.dao.StockDailyBasicMapper;
import org.example.dao.StockQualityMapper;
import org.example.service.JapanCandleService;
import org.example.utils.AlgorithmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JapanCandleServiceImpl implements JapanCandleService {
    @Autowired
    private StockDailyBasicMapper stockDailyBasicMapper;
    @Autowired
    private StockQualityMapper stockQualityMapper;

    @Override
    public List<StartStarInfo> getStartStarList(Integer beginDate,
                                                Integer endDate,
                                                Double firstThreshold,
                                                Double thirdThreshold) {
        List<StartStarInfo> startStarInfos = new ArrayList<>();
        int begin = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, beginDate);
        int end = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, endDate);

        for (int index = begin; index <= end; index++) {
            String date = Constant.TRADE_DAYS.get(index).toString();
            String secondDay = Constant.TRADE_DAYS.get(index - 1).toString();
            String firstDay = Constant.TRADE_DAYS.get(index - 2).toString();
            String nextDay = Constant.TRADE_DAYS.get(index + 1).toString();
            String next2Day = Constant.TRADE_DAYS.get(index + 2).toString();
            String next5Day = Constant.TRADE_DAYS.get(index + 5).toString();
            String next10Day = Constant.TRADE_DAYS.get(index + 10).toString();
            String next20Day = Constant.TRADE_DAYS.get(index + 20).toString();
            List<StockDailyBasic> StockDailyBasics = stockDailyBasicMapper.selectStartStarStock(firstDay, secondDay, date, firstThreshold, thirdThreshold);

            for (StockDailyBasic stockDailyBasic : StockDailyBasics) {
                String tsCode = stockDailyBasic.getTsCode();
                StockQuality stockQuality = stockQualityMapper.selectStockQuality(tsCode, date, nextDay, next2Day, next5Day, next10Day, next20Day);
                StartStarInfo startStarInfo = new StartStarInfo(stockDailyBasic, stockQuality);
                startStarInfos.add(startStarInfo);
            }
        }
        return startStarInfos;
    }

    @Override
    public List<StartStarInfo> getPreStartStarList(Integer beginDate,
                                                   Integer endDate,
                                                   Double firstThreshold) {
        List<StartStarInfo> startStarInfos = new ArrayList<>();
        int begin = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, beginDate);
        int end = AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, endDate);

        for (int index = begin; index <= end; index++) {
            String date = Constant.TRADE_DAYS.get(index).toString();
            String firstDay = Constant.TRADE_DAYS.get(index - 1).toString();
            String nextDay = Constant.TRADE_DAYS.get(index + 1).toString();
            String next2Day = Constant.TRADE_DAYS.get(index + 2).toString();
            String next5Day = Constant.TRADE_DAYS.get(index + 5).toString();
            String next10Day = Constant.TRADE_DAYS.get(index + 10).toString();
            String next20Day = Constant.TRADE_DAYS.get(index + 20).toString();
            List<StockDailyBasic> StockDailyBasics = stockDailyBasicMapper.selectPreStartStarStock(firstDay, date, firstThreshold);

            for (StockDailyBasic stockDailyBasic : StockDailyBasics) {
                String tsCode = stockDailyBasic.getTsCode();
                StockQuality stockQuality = stockQualityMapper.selectStockQuality(tsCode, date, nextDay, next2Day, next5Day, next10Day, next20Day);
                StartStarInfo startStarInfo = new StartStarInfo(stockDailyBasic, stockQuality);
                startStarInfos.add(startStarInfo);
            }
        }
        return startStarInfos;
    }

    public List<StockDailyBasic> getHammerStockList(Integer beginDate,
                                                    Integer endDate,
                                                    Double threshold) {
        return stockDailyBasicMapper.selectHammerStock(beginDate.toString(), endDate.toString(), threshold);
    }
}
