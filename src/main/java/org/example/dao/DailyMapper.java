package org.example.dao;

import java.util.List;
import org.example.entity.Daily;

public interface DailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Daily record);

    Daily selectByPrimaryKey(Integer id);

    List<Daily> selectAll();

    int updateByPrimaryKey(Daily record);
}