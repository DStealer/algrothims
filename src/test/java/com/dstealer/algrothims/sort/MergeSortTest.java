package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        Assistant.print(arr);
        MergeSort.sort(arr);
        Assistant.print(arr);
        Assistant.checkAsc(arr);
    }

    @Test
    public void sort1() {
        MergeSort.merge(new int[]{53, 69, 78, 30, 76}, 0, 2, 4);
    }
}