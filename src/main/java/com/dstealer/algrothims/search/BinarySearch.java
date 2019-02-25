package com.dstealer.algrothims.search;

/**
 * 二分查找法
 */
public class BinarySearch {
    /**
     * @param arr  有序数组
     * @param item 元素
     * @return
     */
    public static int search(int[] arr, int item) {
        //在[l,r]中查找
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            //int m = (l + r) / 2; //溢出问题
            int m = l + (r - l) / 2;
            if (arr[m] == item) {
                return m;
            } else if (arr[m] < item) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
