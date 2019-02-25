package com.dstealer.algrothims.miscellane;

import org.junit.Assert;
import org.junit.Test;

public class OverflowTest {
    @Test
    public void infinity() {
        Assert.assertTrue(Double.isInfinite(Overflow.infinity()));
    }

    @Test
    public void overflow() {
        System.out.println(Overflow.overflow());
    }

}