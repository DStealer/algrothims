package com.dstealer.algrothims.common;

import java.util.Random;

/**
 * 常用操作,算法简单阻力函数
 */
public abstract class Assistant {
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
     * 交换数组中两个元素
     *
     * @param arr
     * @param i1
     * @param i2
     * @return
     */
    public static void swapInt(int[] arr, int i1, int i2) {
        if (i1 != i2) {
            arr[i1] = arr[i1] + arr[i2];
            arr[i2] = arr[i1] - arr[i2];
            arr[i1] = arr[i1] - arr[i2];
        }
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

    /**
     * 生成近乎有序数组
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static int[] generateNealyOrderArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        int range = rangeR - rangeL;
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (range * (1.0 * i / n)) + +rangeL;
        }
        Random random = new Random();
        int swapTime = random.nextInt(n) / 10;
        for (int i = 0; i < swapTime; i++) {
            Assistant.swapInt(arr, random.nextInt(n), random.nextInt(n));
        }
        return arr;
    }

    /**
     * 生成随机的数组
     *
     * @param n
     * @param max
     * @return
     */
    public static int[] generateRandomArray(int n, int max) {
        return new Random().ints(n, 0, max).toArray();
    }

    /**
     * 确认升序
     *
     * @param arr
     */
    public static void checkAsc(int[] arr) {
        int f = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (f <= arr[i]) {
                f = arr[i];
            } else {
                throw new IllegalStateException(f + ">" + arr[i]);
            }
        }
    }

    /**
     * 确认降序
     *
     * @param arr
     */
    public static void checkDasc(int[] arr) {
        int f = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (f >= arr[i]) {
                f = arr[i];
            } else {
                throw new IllegalStateException(f + "<" + arr[i]);
            }
        }
    }

    /**
     * 打印数组
     *
     * @param arr
     * @param width
     */
    public static void print(int[] arr, int width) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            if ((i + 1) % width == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
