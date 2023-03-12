package org.example.service;

/**
 * 均线相关服务接口
 */
public interface AvgLineService {
    /**
     * 从上次更新的结束时间开始，将所有均线更新到现在
     *
     * @return 更新成功标志
     */
    boolean updateRecentAllAvgLine();

    /**
     * 从上次更新5日均线开始，更新到现在
     *
     * @return 更新成功标志
     */
    boolean updateRecentFiveAvgLine();

    /**
     * 更新指定日期的5日均线
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 更新成功标志
     */
    boolean updateFiveAvgLine(Integer beginDate, Integer endDate);

    /**
     * 从上次更新10日均线开始，更新到现在
     *
     * @return 更新成功标志
     */
    boolean updateRecentTenAvgLine();

    /**
     * 更新指定日期的10日均线
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 更新成功标志
     */
    boolean updateTenAvgLine(Integer beginDate, Integer endDate);
}
