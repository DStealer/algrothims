package com.dstealer.algrothims.sort;

/**
 * 归并排序
 * 分而治之,
 * 1 拆分各个小数组
 * 2 合并各个小的有序数组
 * o(nlog2n)
 * 优化思路:
 * 1 小数组使用插入排序
 * 2 已经有序的不需要排序
 */
public class MergeSort {
    public static void sort(int[] arr, int flag) {
        switch (flag) {
            case 1:
                _sortTop2Bottom(arr, 0, arr.length - 1);
                break;
            case -1:
                _sortBottom2Top(arr, arr.length);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * 使用递归从top到bottom归并
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void _sortTop2Bottom(int[] arr, int l, int r) {
        int mid = (l + r) / 2; //越界问题
        if (l < mid) {
            _sortTop2Bottom(arr, l, mid);
        }
        if (mid + 1 < r) {
            _sortTop2Bottom(arr, mid + 1, r);
        }
        if (arr[mid] < arr[mid + 1]) { //有序优化,已经有序
            merge(arr, l, mid, r);
        }
    }

    /**
     * 循环处理,从bottom到top归并
     *
     * @param arr
     * @param n
     */
    private static void _sortBottom2Top(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
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
