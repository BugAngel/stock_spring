package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.bean.StockDailyBasic;

import java.util.List;

public interface StockDailyBasicMapper {
    List<StockDailyBasic> selectStartStarStock(@Param("firstDate") String firstDate,
                                               @Param("secondDate") String secondDate,
                                               @Param("thirdDate") String thirdDate,
                                               @Param("firstThreshold") Double firstThreshold,
                                               @Param("thirdThreshold") Double thirdThreshold);
}