package org.example.dao;

import java.util.List;
import org.example.entity.StockBasic;

public interface StockBasicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockBasic record);

    StockBasic selectByPrimaryKey(Integer id);

    List<StockBasic> selectAll();

    int updateByPrimaryKey(StockBasic record);
}