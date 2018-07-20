package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void sort() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        InsertionSort.sort(arr);
        Assistant.checkAsc(arr);
    }

    @Test
    public void sortAssgin() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        InsertionSort.sortAssgin(arr);
        Assistant.checkAsc(arr);
    }
}