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
        Assert.assertEquals(-2147483648, Overflow.overflow());
    }

    @Test
    public void overflow2() {
        System.out.println(2e-6 * 1000000.1);
    }
}