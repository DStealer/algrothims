package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;

import java.util.Random;

/**
 * 1 快速排序
 * 拆分 对 数组进行部分 partition 操作
 * 返回p 使得 arr[ l...p-1] < arr[p] ,arr[p+1] > arr[p]
 */
public class QuickSort {

    public static void sort(int[] arr) {
        _sort(arr, 0, arr.length - 1);
    }

    public static void sort2(int[] arr) {
        _sort2(arr, 0, arr.length - 1);
    }

    public static void sort3(int[] arr) {
        _sort3(arr, 0, arr.length - 1);
    }

    /**
     * 三路排序
     *
     * @param arr
     */
    public static void sort4(int[] arr) {
        _sort4(arr, 0, arr.length - 1);
    }

    private static void _sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        _sort(arr, l, p - 1);
        _sort(arr, p + 1, r);
    }


    private static int partition(int[] arr, int l, int r) {
        int j = l; //j是标杆位置
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[l]) {
                Assistant.swapInt(arr, i, j++);
            }
        }
        Assistant.swapInt(arr, l, j);
        return j;
    }

    private static void _sort2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        _sort2(arr, l, p - 1);
        _sort2(arr, p + 1, r);
    }

    private static int partition2(int[] arr, int l, int r) {
        //在数组近乎有序的情况下,优化标杆值
        Assistant.swapInt(arr, l, new Random().nextInt(r - l + 1) + l);

        int j = l;
        int v = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                Assistant.swapInt(arr, j + 1, i);
                j++;
            }
        }
        Assistant.swapInt(arr, l, j);
        return j;
    }

    private static void _sort3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition3(arr, l, r);
        _sort3(arr, l, p - 1);
        _sort3(arr, p + 1, r);
    }

    private static int partition3(int[] arr, int l, int r) {
        //大量重复元素优化

        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l + 1 && arr[j] > v) j--;
            if (i > j) break;
            else {
                Assistant.swapInt(arr, i++, j--);
            }
        }
        Assistant.swapInt(arr, l, j);
        return j;
    }

    private static void _sort4(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int v = arr[l];
        int lt = l;  //小于v元素的边界
        int gt = r + 1; //大于v元素的边界

        int i = l + 1; //考察元素
        while (i < gt) {
            if (arr[i] < v) {
                Assistant.swapInt(arr, i++, ++lt);
            } else if (arr[i] > v) {
                Assistant.swapInt(arr, i, --gt);
                //i 不需要变化 gt 位置元素不确定
            } else {
                i++;
            }
        }
        Assistant.swapInt(arr, l, lt);  //lt 在最后交换后+1

        _sort4(arr, l, lt - 1);
        _sort4(arr, gt, r);
    }

}
