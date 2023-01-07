package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.Constant;
import org.example.bean.StartStarInfo;
import org.example.bean.StockDailyBasic;
import org.example.bean.StockQuality;
import org.example.dao.StockDailyBasicMapper;
import org.example.dao.StockQualityMapper;
import org.example.service.StartStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StartStarServiceImpl implements StartStarService {
    @Autowired
    private StockDailyBasicMapper stockDailyBasicMapper;
    @Autowired
    private StockQualityMapper stockQualityMapper;

    @Override
    public PageInfo<StartStarInfo> list(String date,
                                          Double firstThreshold,
                                          Double thirdThreshold,
                                          Integer pageNum,
                                          Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        int index = Collections.binarySearch(Constant.TRADE_DAYS, date);
        String secondDay = Constant.TRADE_DAYS.get(index - 1);
        String firstDay = Constant.TRADE_DAYS.get(index - 2);
        String nextDay = Constant.TRADE_DAYS.get(index + 1);
        String next2Day = Constant.TRADE_DAYS.get(index + 2);
        String next5Day = Constant.TRADE_DAYS.get(index + 5);
        String next10Day = Constant.TRADE_DAYS.get(index + 10);
        String next20Day = Constant.TRADE_DAYS.get(index + 20);
        List<StockDailyBasic> StockDailyBasics = stockDailyBasicMapper.selectStartStarStock(firstDay, secondDay, date, firstThreshold, thirdThreshold);

        List<StartStarInfo> startStarInfos = new ArrayList<>();
        for (StockDailyBasic stockDailyBasic : StockDailyBasics) {
            String tsCode = stockDailyBasic.getTsCode();
            StockQuality stockQuality = stockQualityMapper.selectStockQuality(tsCode, date, nextDay, next2Day, next5Day, next10Day, next20Day);
            StartStarInfo startStarInfo = new StartStarInfo(stockDailyBasic, stockQuality);
            startStarInfos.add(startStarInfo);
        }

        return new PageInfo<>(startStarInfos);
    }
}
