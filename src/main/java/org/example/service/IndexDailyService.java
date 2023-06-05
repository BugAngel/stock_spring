package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.entity.IndexDaily;

import java.util.List;

public interface IndexDailyService extends IService<IndexDaily> {
    String getNextDate();

    List<IndexDaily> getShByTradeDate(String beginDate, String endDate);
}
