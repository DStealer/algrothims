package com.dstealer.algrothims.common;

import java.util.Random;

/**
 * 常用操作,算法简单阻力函数
 */
public abstract class SortHelper {
    /**
     * 交换两个int
     *
     * @param i1
     * @param i2
     * @return
     */
    public static Pair<Integer> swapInt(int i1, int i2) {
        i1 = i1 + i2;
        i2 = i1 - i2;
        i1 = i1 - i2;
        return new Pair<>(i1, i2);
    }

    /**
     * 生成随机的数组
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        return new Random().ints(n, rangeL, rangeR).toArray();
    }
}
