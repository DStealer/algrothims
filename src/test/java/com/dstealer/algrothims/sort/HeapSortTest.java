package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

public class HeapSortTest {
    @Test
    public void sort() {
        int[] arr = Assistant.generateRandomArray(101111, 100);
        HeapSort.sort(arr);
        Assistant.checkAsc(arr);
    }
}