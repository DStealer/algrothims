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

    private static void _sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        _sort(arr, l, p - 1);
        _sort(arr, p + 1, r);
    }


    private static int partition(int[] arr, int l, int r) {
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
}
