package org.example.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.TradeCal;

public interface TradeCalMapper extends BaseMapper<TradeCal> {
    int deleteByPrimaryKey(Integer id);

    TradeCal selectByPrimaryKey(Integer id);

    List<TradeCal> selectAll();

    int updateByPrimaryKey(TradeCal record);

    List<TradeCal> selectOpenAll();
}