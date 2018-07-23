package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;

/**
 * 选择排序
 * 1 外层遍历数组, 并记录此次遍历的下标位置i
 * 2 遍历i以及i之后的元素,寻找最小的元素并记录下标j
 * 3 交换i和j位置的元素
 *  o(n2)
 */
public class SelectionSort {
    /**
     * 排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Assistant.swapInt(arr, i, minIndex);
            }
        }
    }
}
