package org.example.utils;

import java.util.List;

public class AlgorithmUtil {
    /**
     * 二分取列表中的值。如果值不存在，则取左侧值
     * @param list 列表
     * @param value 目标值
     * @return 如果值存在,则为列表下标;如果值不存在,则返回最近的左侧值
     */
    public static int binarySearch(List<Integer> list, Integer value) {
        int start = 0;
        int end = list.size() - 1;
        int middle;

        while (start <= end) {
            middle = (end - start) / 2 + start;
            if (list.get(middle) < value) {
                start = middle + 1;
            } else if (list.get(middle) > value) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return end;
    }
}
