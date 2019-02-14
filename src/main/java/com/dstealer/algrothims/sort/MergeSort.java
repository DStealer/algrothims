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
                _sortBottom2Top(arr, 0, arr.length - 1);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * 使用递归从top到bottom归并
     *
     * @param arr
     * @param l   下标
     * @param r   下标
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
     * @param l
     * @param r
     */
    private static void _sortBottom2Top(int[] arr, int l, int r) {
        for (int sz = l + 1; sz <= (r - l + 1); sz += sz) {
            for (int i = l; i < (r - l + 1); i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, r));
            }
        }
    }

    /**
     * 取数组 arr的[l,mid] [mid+1,r]元素合并排序
     *
     * @param arr
     * @param leftBound  下标
     * @param middle     下标
     * @param rightBound 下标
     */
    public static void merge(int[] arr, int leftBound, int middle, int rightBound) {
        int[] auxArr = new int[rightBound - leftBound + 1];
        System.arraycopy(arr, leftBound, auxArr, 0, rightBound - leftBound + 1);
        int li = leftBound; //原数组下标
        int ri = middle + 1; //原数组下标

        for (int arri = leftBound; arri <= rightBound; arri++) {
            if (li > middle) {
                arr[arri] = auxArr[ri - leftBound]; //推算帮助数组位置
                ri++;
            } else if (ri > rightBound) {
                arr[arri] = auxArr[li - leftBound];
                li++;
            } else if (auxArr[li - leftBound] < auxArr[ri - leftBound]) { //先考虑写出比较的步骤,使用帮助数组中的数据
                arr[arri] = auxArr[li - leftBound];
                li++;
            } else {
                arr[arri] = auxArr[ri - leftBound];
                ri++;
            }
        }
    }

}
