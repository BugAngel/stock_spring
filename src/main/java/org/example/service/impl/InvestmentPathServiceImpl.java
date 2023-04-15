package org.example.service.impl;

import org.example.bean.TwoYearHighBean;
import org.example.dao.TwoYearHighMapper;
import org.example.service.InvestmentPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentPathServiceImpl implements InvestmentPathService {
    @Autowired
    private TwoYearHighMapper twoYearHighMapper;

    /**
     * 2年新高股票
     *
     * @param date 日期
     * @return 2年新高股票信息
     */
    @Override
    public List<TwoYearHighBean> twoYearHighStocks(Integer date) {
        return twoYearHighMapper.selectTwoYearHighStocks(date);
    }
}
