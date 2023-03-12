package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.bean.StartStarInfo;
import org.example.bean.StockDailyBasic;

import java.util.List;

public interface JapanCandleService {
    List<StartStarInfo> getStartStarList(Integer beginDate,
                                         Integer endDate,
                                         Double firstThreshold,
                                         Double thirdThreshold);

    List<StartStarInfo> getPreStartStarList(Integer beginDate,
                                            Integer endDate,
                                            Double firstThreshold);

    List<StockDailyBasic> getHammerStockList(Integer beginDate,
                                             Integer endDate,
                                             Double threshold);
}
