package org.example.service.impl;

import org.example.dao.TradeCalMapper;
import org.example.entity.TradeCal;
import org.example.service.TradeDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeDaysServiceImpl implements TradeDaysService {
    @Autowired
    private TradeCalMapper tradeCalMapper;

    @Override
    public List<String> getTradeDays(){
        List<TradeCal> tradeCals = tradeCalMapper.selectOpenAll();
        List<String> res = new ArrayList<>();
        for(TradeCal tradeCal:tradeCals){
            res.add(tradeCal.getCalDate());
        }
        return res;
    }
}
