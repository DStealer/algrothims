package com.dstealer.algrothims.sort;

/**
 * 归并排序
 * 分而治之,
 * 1 拆分各个小数组
 * 2 合并各个小的有序数组
 * o(nlog2n)
 */
public class MergeSort {
    public static void sort(int[] arr) {
        _sort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr
     * @param l
     * @param r
     */
    private static void _sort(int[] arr, int l, int r) {
        int mid = (l + r) / 2; //越界问题
        if (l < mid) {
            _sort(arr, l, mid);
        }
        if (mid + 1 < r) {
            _sort(arr, mid + 1, r);
        }
        merge(arr, l, mid, r);
    }

    /**
     * 取数组 arr的[l,mid] [mid+1,r]元素合并排序
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] auxArr = new int[r - l + 1];
        System.arraycopy(arr, l, auxArr, 0, r - l + 1);
        int li = l;
        int ri = mid + 1;
        for (int arri = l; arri <= r; arri++) {
            if (li > mid) {
                arr[arri] = auxArr[ri - l];
                ri++;
            } else if (ri > r) {
                arr[arri] = auxArr[li - l];
                li++;
            } else if (auxArr[li - l] < auxArr[ri - l]) {
                arr[arri] = auxArr[li - l];
                li++;
            } else {
                arr[arri] = auxArr[ri - l];
                ri++;
            }
        }
    }

}
