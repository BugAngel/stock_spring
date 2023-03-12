package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.bean.StockDailyBasic;

import java.util.List;

public interface StockDailyBasicMapper extends BaseMapper<StockDailyBasic> {
    List<StockDailyBasic> selectStartStarStock(@Param("firstDate") String firstDate,
                                               @Param("secondDate") String secondDate,
                                               @Param("thirdDate") String thirdDate,
                                               @Param("firstThreshold") Double firstThreshold,
                                               @Param("thirdThreshold") Double thirdThreshold);

    List<StockDailyBasic> selectPreStartStarStock(@Param("firstDate") String firstDate,
                                                  @Param("secondDate") String secondDate,
                                                  @Param("firstThreshold") Double firstThreshold);

    List<StockDailyBasic> selectHammerStock(@Param("beginDate") String beginDate,
                                            @Param("endDate") String endDate,
                                            @Param("threshold") Double threshold);

    List<StockDailyBasic> selectStockDailyBasicFromDailyIds(@Param("ids") List<Integer> ids);
}