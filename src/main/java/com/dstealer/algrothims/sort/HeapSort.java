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
        //heapify
        for (int i = (len / 2 - 1); i >= 0; i--) { //第一个非页节点
            _shiftDown(arr, len, i);
        }
        //最大堆出栈 即排序
        for (int i = len - 1; i > 0; i--) {
            Assistant.swapInt(arr, i, 0);
            _shiftDown(arr, i, 0);
        }

    }

    /**
     * 出堆和堆化时需要
     *
     * @param arr   数组
     * @param len   堆大小
     * @param index 需要寻找位置的元素
     */
    private static void _shiftDown(int[] arr, int len, int index) {
        while (2 * index + 1 < len) { //有左子节点
            int leftNodeIndex = 2 * index + 1; //左子节点索引
            int rightNodeIndex = 2 * index + 2; //右子节点索引

            int maxNodePos = leftNodeIndex;
            if (rightNodeIndex < len && arr[rightNodeIndex] > arr[leftNodeIndex]) { // 有右子节点 并且 右子节点比左子节点大
                maxNodePos = rightNodeIndex;
            }

            if (arr[index] >= arr[maxNodePos]) {
                break;
            }
            Assistant.swapInt(arr, index, maxNodePos);

            index = maxNodePos;
        }
    }

    /**
     * 入堆时需要的操作
     *
     * @param arr
     * @param len
     * @param index
     */
    private static void _shiftUP(int[] arr, int len, int index) {
        while (index > 1 && arr[index] > arr[index / 2]) {
            Assistant.swapInt(arr, index, index / 2);
            index = index / 2;
        }
    }
}
