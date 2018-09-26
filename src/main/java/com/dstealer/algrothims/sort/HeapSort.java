package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;

/**
 * 使用最大完全二叉堆排序
 * 1 堆化数组
 * 2 交换数组第一个位置和最后一个位置元素(入堆和出堆)
 * <p>
 * 完全二叉最大堆(0base)
 * 属性:
 * 1 左子节点 2i+1
 * 2 右子节点 2i+2
 * 3 父节点 (i-1)/2
 * 4 第一个非叶子节点 len/2 -1
 */
public class HeapSort {
    public static void sort(int[] arr) {
        _sort(arr, arr.length);
    }

    /**
     * 排序
     *
     * @param arr 索引
     * @param len 堆大小
     */
    public static void _sort(int[] arr, int len) {
        //first heapify
        for (int i = (len / 2 - 1); i >= 0; i--) {
            _shiftDown(arr, len, i);
        }
        //排序
        for (int i = len - 1; i > 0; i--) {
            Assistant.swapInt(arr, i, 0);
            _shiftDown(arr, i, 0);
        }

    }

    /**
     * @param arr 数组
     * @param len 堆大小
     * @param pos 需要寻找位置的元素
     */
    private static void _shiftDown(int[] arr, int len, int pos) {
        while (2 * pos + 1 < len) {
            int ll = 2 * pos + 1;
            int lr = ll + 1;
            int mc = ll;
            if (lr < len && arr[lr] > arr[ll]) {
                mc = lr;
            }
            if (arr[pos] >= arr[mc]) {
                break;
            }
            Assistant.swapInt(arr, pos, mc);
            pos = mc;
        }
    }
}
