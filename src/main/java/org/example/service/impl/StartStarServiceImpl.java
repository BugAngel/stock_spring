package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.Constant;
import org.example.bean.StockDailyBasic;
import org.example.dao.StockDailyBasicMapper;
import org.example.service.StartStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StartStarServiceImpl implements StartStarService {
    @Autowired
    private StockDailyBasicMapper stockDailyBasicMapper;

    @Override
    public PageInfo<StockDailyBasic> list(String date,
                                          Double firstThreshold,
                                          Double thirdThreshold,
                                          Integer pageNum,
                                          Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        String firstDate = date;
        int index = Collections.binarySearch(Constant.TRADE_DAYS, date);
        String secondDate = Constant.TRADE_DAYS.get(index + 1);
        String thirdDate = Constant.TRADE_DAYS.get(index + 2);
        List<StockDailyBasic> list = stockDailyBasicMapper.selectStartStarStock(firstDate, secondDate, thirdDate, firstThreshold, thirdThreshold);
        return new PageInfo<>(list);
    }
}
