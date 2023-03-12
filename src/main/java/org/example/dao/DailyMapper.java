package org.example.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Daily;

public interface DailyMapper extends BaseMapper<Daily> {
    int deleteByPrimaryKey(Integer id);

    Daily selectByPrimaryKey(Integer id);

    List<Daily> selectAll();

    int updateByPrimaryKey(Daily record);

    @Select("SELECT * FROM daily WHERE trade_date BETWEEN #{beginDate,jdbcType=VARCHAR} AND #{endDate,jdbcType=VARCHAR}")
    List<Daily> selectByTradeDate(@Param("beginDate") String beginDate,
                                  @Param("endDate") String endDate);
}