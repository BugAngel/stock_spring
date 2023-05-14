package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.IndexDaily;

public interface IndexDailyMapper extends BaseMapper<IndexDaily>  {
    @Select("SELECT DATE_ADD(max_date,INTERVAL 1 DAY) FROM (SELECT MAX(trade_date) AS max_date FROM index_daily WHERE ts_code = '000001.SH') AS a")
    String getNextDate();
}
