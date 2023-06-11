package org.example.service.impl;

import org.example.bean.StockDailyBasic;
import org.example.dao.StockDailyBasicMapper;
import org.example.service.InvestmentPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentPathServiceImpl implements InvestmentPathService {
    @Autowired
    private StockDailyBasicMapper stockDailyBasicMapper;

    /**
     * 2年新高股票
     *
     * @param date 日期
     * @return 2年新高股票信息
     */
    @Override
    public List<StockDailyBasic> twoYearHighStocks(Integer date) {
        return stockDailyBasicMapper.selectTwoYearHighStocks(date);
    }

    @Override
    public List<StockDailyBasic> nearTwoYearHighStocks(Integer date,Double threshold){
        return stockDailyBasicMapper.selectNearTwoYearHighStocks(date,threshold);
    }
}
