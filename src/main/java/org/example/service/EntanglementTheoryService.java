package org.example.service;

import org.example.bean.StockDailyBasic;

import java.util.List;

/**
 * 缠论服务相关接口
 */
public interface EntanglementTheoryService {
    /**
     * 大趋势上升,小趋势回调
     *
     * @param date     时间
     * @param range    时间范围
     * @param minSlope 拟合直线最小斜率
     * @param maxSlope 拟合直线最大斜率
     * @param callback 回调大小
     * @return 股票列表
     */
    List<StockDailyBasic> getRisingCorrectionList(Integer date,
                                                  Integer range,
                                                  Double minSlope,
                                                  Double maxSlope,
                                                  Double callback);
}
