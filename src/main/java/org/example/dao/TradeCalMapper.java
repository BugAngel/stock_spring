package org.example.dao;

import java.util.List;
import org.example.entity.TradeCal;

public interface TradeCalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeCal record);

    TradeCal selectByPrimaryKey(Integer id);

    List<TradeCal> selectAll();

    int updateByPrimaryKey(TradeCal record);

    List<TradeCal> selectOpenAll();
}