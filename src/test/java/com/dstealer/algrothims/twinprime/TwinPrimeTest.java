package com.dstealer.algrothims.twinprime;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwinPrimeTest {

    @Test
    public void twinPrimeNum() {
        Assert.assertEquals(1, TwinPrime.twinPrimeNum(5));
        Assert.assertEquals(35, TwinPrime.twinPrimeNum(1000));
    }
}