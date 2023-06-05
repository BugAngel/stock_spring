package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.IndexDailyMapper;
import org.example.entity.IndexDaily;
import org.example.service.IndexDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexDailyServiceImpl extends ServiceImpl<IndexDailyMapper, IndexDaily> implements IndexDailyService {
    @Autowired
    IndexDailyMapper indexDailyMapper;

    public String getNextDate(){
        return indexDailyMapper.getNextDate();
    }

    public List<IndexDaily> getShByTradeDate(String beginDate, String endDate){
        return indexDailyMapper.selectShByTradeDate(beginDate, endDate);
    }
}
