package org.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Daily;

public interface DailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Daily record);

    Daily selectByPrimaryKey(Integer id);

    List<Daily> selectAll();

    int updateByPrimaryKey(Daily record);

    @Select("SELECT * FROM daily WHERE trade_date BETWEEN #{beginDate,jdbcType=INTEGER} AND #{endDate,jdbcType=INTEGER}")
    List<Daily> selectByTradeDate(@Param("beginDate") String beginDate,
                                  @Param("endDate") String endDate);
}