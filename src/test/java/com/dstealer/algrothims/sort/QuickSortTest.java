package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {
    @Test
    public void sort() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        System.out.println(Arrays.toString(arr));
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        Assistant.checkAsc(arr);
    }
}