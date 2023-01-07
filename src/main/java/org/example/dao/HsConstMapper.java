package org.example.dao;

import java.util.List;
import org.example.entity.HsConst;

public interface HsConstMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HsConst record);

    HsConst selectByPrimaryKey(Integer id);

    List<HsConst> selectAll();

    int updateByPrimaryKey(HsConst record);
}