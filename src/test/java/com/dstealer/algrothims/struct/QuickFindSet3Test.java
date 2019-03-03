package com.dstealer.algrothims.struct;

import org.junit.Assert;
import org.junit.Test;

public class QuickFindSet3Test {
    @Test
    public void test01() {
        QuickFindSet3 set = new QuickFindSet3(10);
        for (int i = 0; i < 10; i++) {
            set.set(i, i);
        }

        set.union(0, 1);

        Assert.assertTrue(set.isUnion(0, 1));
        Assert.assertEquals(2, set.findLevel(0));

        set.union(1, 2);

        Assert.assertTrue(set.isUnion(1, 2));

        Assert.assertEquals(3, set.findLevel(0));
    }
}