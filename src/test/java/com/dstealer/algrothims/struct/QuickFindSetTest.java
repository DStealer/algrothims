package com.dstealer.algrothims.struct;

import org.junit.Assert;
import org.junit.Test;

public class QuickFindSetTest {
    @Test
    public void test01() {
        QuickFindSet set = new QuickFindSet(10);
        for (int i = 0; i < 10; i++) {
            set.set(i, i);
        }

        Assert.assertFalse(set.isUnion(0, 1));
        set.union(0, 1);
        Assert.assertTrue(set.isUnion(0, 1));
    }
}