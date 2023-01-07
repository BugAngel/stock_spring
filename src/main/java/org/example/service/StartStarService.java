package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.bean.StockDailyBasic;

public interface StartStarService {
    PageInfo<StockDailyBasic> list(String date,
                                   Double firstThreshold,
                                   Double thirdThreshold,
                                   Integer pageNum,
                                   Integer pageSize);
}
