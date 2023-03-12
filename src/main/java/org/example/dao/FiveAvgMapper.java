package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.FiveAvg;

import java.util.List;

public interface FiveAvgMapper extends BaseMapper<FiveAvg> {
    @Select("SELECT MAX(trade_date) FROM five_avg")
    Integer selectMinTradeDate();

    @Delete("DELETE FROM five_avg WHERE trade_date BETWEEN #{beginDate,jdbcType=INTEGER} AND #{endDate,jdbcType=INTEGER}")
    int deleteByTradeDate(@Param("beginDate") Integer beginDate,
                          @Param("endDate") Integer endDate);

    @Select("SELECT * FROM five_avg WHERE trade_date BETWEEN #{beginDate,jdbcType=INTEGER} AND #{endDate,jdbcType=INTEGER}")
    List<FiveAvg> selectByTradeDate(@Param("beginDate") Integer beginDate,
                                    @Param("endDate") Integer endDate);
}