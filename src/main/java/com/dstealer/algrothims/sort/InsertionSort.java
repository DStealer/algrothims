package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;

/**
 * 插入排序,
 * 1 从第1个位置外层遍历元素,设当前遍历元素下标为i
 * 2 用当前元素与前继节点比较,如果小于前继节点,则交换位置,循环此步直至不小于前继节点
 * o(n2)
 * 默认第i个元素之前的元素是有序的
 */
public class InsertionSort {
    /**
     * 排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                Assistant.swapInt(arr, j, j - 1);
            }
        }
    }

    /**
     * 排序,提前终止内层循环
     *
     * @param arr
     */
    public static void sortAssgin(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
