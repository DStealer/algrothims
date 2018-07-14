package com.dstealer.algrothims.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortHelperTest {

    @Test
    public void generateRandomArray() {
        int[] arr = SortHelper.generateRandomArray(100, 5, 10);
        Assert.assertEquals(100, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}