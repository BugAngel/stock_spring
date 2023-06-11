package org.example.service;

import org.example.bean.StockDailyBasic;

import java.util.List;

/**
 * 投资正途相关指标
 */
public interface InvestmentPathService {
    /**
     * 2年新高股票
     * @param date 日期
     * @return 2年新高股票信息
     */
    List<StockDailyBasic> twoYearHighStocks(Integer date);

    List<StockDailyBasic> nearTwoYearHighStocks(Integer date,Double threshold);
}
