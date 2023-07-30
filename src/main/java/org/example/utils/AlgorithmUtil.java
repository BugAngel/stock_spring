package org.example.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmUtil {
    /**
     * 二分取列表中的值。如果值不存在，则取左侧值
     *
     * @param list  列表
     * @param value 目标值
     * @return 如果值存在, 则为列表下标;如果值不存在,则返回最近的左侧值
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

    /**
     * 归一化，把最大值归为100
     *
     * @param data 原始数组
     * @return 归一化后的数组
     */
    public static double[] normalization(double[] data) {
        double max = Arrays.stream(data).max().getAsDouble();
        double ratio = 100 / max;
        double[] res = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            res[i] = data[i] * ratio;
        }
        return res;
    }


    /**
     * 最小二乘法拟合直线的斜率
     *
     * @param data 数组下标是x轴值，value是y轴值
     * @return 拟合直线斜率
     */
    public static double linerRegressionSlope(double[] data) {
        int len = data.length;
        double[] x = new double[len];
        for (int i = 0; i < len; i++) {
            x[i] = i;
        }
        return lineRegression(x, data).get("k");
    }

    /**
     * 最小二乘法,拟合 y=kx+b,r
     *
     * @param X 数组X,对应点X轴值
     * @param Y 数组Y,对应点Y轴值
     * @return y=kx+b,r
     */
    public static Map<String, Double> lineRegression(double[] X, double[] Y) {
        // x平方差和
        double Sxx = varianceSum(X);
        // y平方差和
        double Syy = varianceSum(Y);
        // xy协方差和
        double Sxy = covarianceSum(X, Y);

        double xAvg = arraySum(X) / X.length;
        double yAvg = arraySum(Y) / Y.length;

        double k = Sxy / Sxx;
        double b = yAvg - k * xAvg;

        // 相关系数
        double r = Sxy / Math.sqrt(Sxx * Syy);
        Map<String, Double> result = new HashMap<>();
        result.put("k", k);
        result.put("b", b);
        result.put("r", r);

        return result;
    }

    /**
     * 计算方差和
     *
     * @param data 数组
     * @return 数组方差和
     */
    public static double varianceSum(double[] data) {
        double xAvg = arraySum(data) / data.length;
        return arraySqSum(arrayMinus(data, xAvg));
    }

    /**
     * 计算协方差和
     *
     * @param X 数组X
     * @param Y 数组Y
     * @return 数组协方差和
     */
    public static double covarianceSum(double[] X, double[] Y) {
        double xAvg = arraySum(X) / X.length;
        double yAvg = arraySum(Y) / Y.length;
        return arrayMulSum(arrayMinus(X, xAvg), arrayMinus(Y, yAvg));
    }

    /**
     * 数组减常数
     *
     * @param nums     数组
     * @param constant 常数
     * @return 减常数后数组
     */
    public static double[] arrayMinus(double[] nums, double constant) {
        int n = nums.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] - constant;
        }

        return result;
    }

    /**
     * 数组求和
     *
     * @param data 数组
     * @return 数组和
     */
    public static double arraySum(double[] data) {
        double s = 0;
        for (double x : data) {
            s = s + x;
        }
        return s;
    }

    /**
     * 数组平方求和
     *
     * @param X 数组 X
     * @return 数组平方和
     */
    public static double arraySqSum(double[] X) {
        double s = 0;
        for (double x : X) {
            s = s + Math.pow(x, 2);
        }
        return s;
    }

    /**
     * 数组对应元素相乘求和
     *
     * @param X 数组X
     * @param Y 数组Y
     * @return 对应元素平方和
     */
    public static double arrayMulSum(double[] X, double[] Y) {
        double s = 0;
        for (int i = 0; i < X.length; i++) {
            s = s + X[i] * Y[i];
        }
        return s;
    }
}
