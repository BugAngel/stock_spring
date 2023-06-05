package org.example.service;

import org.example.bean.StockDailyBasic;

import java.util.List;

public interface StockDailyInfoService {
    List<StockDailyBasic> getStockDailyInfo(String beginDate,
                                            String endDate,
                                            String tsCode,
                                            String symbol,
                                            String name,
                                            String industry);

    List<StockDailyBasic> getStockHfqDailyInfo(String beginDate,
                                               String endDate,
                                               String tsCode,
                                               String name,
                                               String industry);
}
