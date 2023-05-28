package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.bean.StockDailyBasic;
import org.example.dao.StockDailyBasicMapper;
import org.example.service.StockDailyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StockDailyInfoServiceImpl implements StockDailyInfoService {
    @Autowired
    StockDailyBasicMapper stockDailyBasicMapper;

    @Override
    public List<StockDailyBasic> getStockDailyInfo(String beginDate,
                                                   String endDate,
                                                   String tsCode,
                                                   String name,
                                                   String industry) {
        return stockDailyBasicMapper.selectStockDailyInfo(beginDate, endDate, tsCode, name, industry);
    }

    @Override
    public List<StockDailyBasic> getStockHfqDailyInfo(String beginDate,
                                                      String endDate,
                                                      String tsCode,
                                                      String name,
                                                      String industry) {
        return stockDailyBasicMapper.selectStockHfqDailyInfo(beginDate, endDate, tsCode, name, industry);
    }
}
