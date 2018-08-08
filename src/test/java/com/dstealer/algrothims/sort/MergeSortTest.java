package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        Assistant.print(arr);
        MergeSort.sort(arr, 1);
        Assistant.print(arr);
        Assistant.checkAsc(arr);
    }

    @Test
    public void sort1() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        Assistant.print(arr);
        MergeSort.sort(arr, -1);
        Assistant.print(arr);
        Assistant.checkAsc(arr);
    }
}