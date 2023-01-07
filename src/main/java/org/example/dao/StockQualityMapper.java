package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.bean.StockQuality;

public interface StockQualityMapper {
    StockQuality selectStockQuality(@Param("tsCode") String tsCode,
                                    @Param("tradeDay") String tradeDay,
                                    @Param("nextDay") String nextDay,
                                    @Param("next2Day") String next2Day,
                                    @Param("next5Day") String next5Day,
                                    @Param("next10Day") String next10Day,
                                    @Param("next20Day") String next20Day);
}