package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.bean.TwoYearHighBean;

import java.util.List;

public interface TwoYearHighMapper {
    List<TwoYearHighBean> selectTwoYearHighStocks(Integer date);
}
