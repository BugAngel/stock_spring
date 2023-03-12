package org.example.utils;

import org.example.Constant;

public class TradeDayUtil {
    /**
     * 获取指定日期的数组下标
     *
     * @param date 日期
     * @return 数组下标
     */
    public static Integer getDateIndex(Integer date) {
        return AlgorithmUtil.binarySearch(Constant.TRADE_DAYS, date);
    }

    /**
     * 获取指定日期,向后 num 个工作日后的日期
     *
     * @param date 日期
     * @param num  向后num个工作日.正数向后,负数向前
     * @return 日期
     */
    public static Integer getAddDate(Integer date, Integer num) {
        int index = getDateIndex(date);
        return Constant.TRADE_DAYS.get(index + num);
    }
}
