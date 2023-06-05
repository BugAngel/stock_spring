package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    List<StockDailyBasic> selectStockDailyInfo(@Param("begin_date") String beginDate,
                                               @Param("end_date") String endDate,
                                               @Param("ts_code") String tsCode,
                                               @Param("symbol") String symbol,
                                               @Param("name") String name,
                                               @Param("industry") String industry);

    List<StockDailyBasic> selectStockHfqDailyInfo(@Param("begin_date") String beginDate,
                                                  @Param("end_date") String endDate,
                                                  @Param("ts_code") String tsCode,
                                                  @Param("name") String name,
                                                  @Param("industry") String industry);
}