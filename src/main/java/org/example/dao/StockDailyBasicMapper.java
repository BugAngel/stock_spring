package org.example.dao;

import org.example.bean.StockDailyBasic;
import org.example.entity.Daily;

import java.util.List;

public interface StockDailyBasicMapper {
    List<StockDailyBasic> selectStartStarStock(String firstDate, String secondDate, String thirdDate, Double firstThreshold, Double thirdThreshold);
}