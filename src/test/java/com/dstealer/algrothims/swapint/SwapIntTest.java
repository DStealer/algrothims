package com.dstealer.algrothims.swapint;

import com.dstealer.algrothims.common.Pair;
import org.junit.Assert;
import org.junit.Test;

public class SwapIntTest {
    int i1 = 7;
    int i2 = 49;
    Pair predict = new Pair<>(i2, i1);

    @Test
    public void swapInt_1() {
        Assert.assertEquals(predict, SwapInt.swapInt_1(i1, i2));
    }

    @Test
    public void swapInt_2() {
        Assert.assertEquals(predict, SwapInt.swapInt_2(i1, i2));
    }

    @Test
    public void swapInt_3() {
        Assert.assertEquals(predict, SwapInt.swapInt_3(i1, i2));
    }
}