package com.dstealer.algrothims.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AssistantTest {

    @Test
    public void generateRandomArray() {
        int[] arr = Assistant.generateRandomArray(100, 5, 10);
        Assert.assertEquals(100, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void print() {
        int[] arr = Assistant.generateRandomArray(100, 0, 100);
        Assistant.print(arr, 10);
    }

    @Test
    public void swapInt() {
        int[] arr = new int[]{1, 2};
        Assistant.swapInt(arr, 0, 1);
        Assert.assertArrayEquals(new int[]{2, 1}, arr);
    }
}