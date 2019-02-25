package com.dstealer.algrothims.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void search() {
        Assert.assertEquals(2, BinarySearch.search(new int[]{1, 3, 4, 9}, 4));
    }
}