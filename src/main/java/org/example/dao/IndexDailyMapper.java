package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.IndexDaily;

import java.util.List;

public interface IndexDailyMapper extends BaseMapper<IndexDaily>  {
    @Select("SELECT DATE_ADD(max_date,INTERVAL 1 DAY) FROM (SELECT MAX(trade_date) AS max_date FROM index_daily WHERE ts_code = '000001.SH') AS a")
    String getNextDate();

    @Select("SELECT * FROM index_daily WHERE trade_date BETWEEN #{beginDate,jdbcType=VARCHAR} AND #{endDate,jdbcType=VARCHAR} AND ts_code = '000001.SH'")
    List<IndexDaily> selectShByTradeDate(@Param("beginDate") String beginDate,
                                         @Param("endDate") String endDate);
}
