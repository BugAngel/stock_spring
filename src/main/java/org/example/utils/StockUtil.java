package org.example.utils;

import org.example.entity.Daily;

import java.util.*;

public class StockUtil {
    /**
     * 按股票聚合每日数据
     *
     * @param dailyList 每日股票数据
     * @return 按股票聚合的每日数据。聚合的每日数据已排序
     */
    public static Map<String, LinkedList<Daily>> dailyAggregateByStock(List<Daily> dailyList) {
        Map<String, LinkedList<Daily>> res = new HashMap<>();
        for (Daily daily : dailyList) {
            LinkedList<Daily> temp = res.getOrDefault(daily.getTsCode(), new LinkedList<>());
            temp.add(daily);
            res.put(daily.getTsCode(), temp);
        }
        for (Map.Entry<String, LinkedList<Daily>> entry : res.entrySet()) {
            LinkedList<Daily> temp = entry.getValue();
            temp.sort(Comparator.comparing(Daily::getTradeDate));
            res.put(entry.getKey(), temp);
        }
        return res;
    }

    /**
     * 获取股票列表中的最大收盘价
     *
     * @param dailyList 股票列表
     * @return 最大价格
     */
    public static Double getStocksMaxClose(LinkedList<Daily> dailyList) {
        Double res = -1.0;
        for (Daily daily : dailyList) {
            res = Math.max(res, daily.getClose().doubleValue());
        }
        return res;
    }

    /**
     * 获取股票列表中的最大收盘价
     *
     * @param dailyList 股票列表
     * @return 最大价格
     */
    public static Map<String, Double> getStocksMaxClose(Map<String, LinkedList<Daily>> dailyList) {
        Map<String, Double> res = new HashMap<>();
        for (Map.Entry<String, LinkedList<Daily>> entry : dailyList.entrySet()) {
            res.put(entry.getKey(), getStocksMaxClose(entry.getValue()));
        }
        return res;
    }

    /**
     * 将股票信息转换为 double[],方便进行数学处理
     *
     * @param dailyList 每日股票信息
     * @return 数组下标是x轴值, 值是y轴值
     */
    public static double[] stockDailyClose2Double(List<Daily> dailyList) {
        double[] data = new double[dailyList.size()];
        for (int x = 0; x < dailyList.size(); x++) {
            data[x] = dailyList.get(x).getClose().doubleValue();
        }
        return data;
    }
}
