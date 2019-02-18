package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void sort() {
        int[] arr = Assistant.generateRandomArray(10000, 100);
        BubbleSort.sort(arr);
        Assistant.checkAsc(arr);
    }
}