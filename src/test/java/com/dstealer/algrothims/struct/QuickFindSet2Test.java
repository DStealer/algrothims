package com.dstealer.algrothims.struct;

import org.junit.Assert;
import org.junit.Test;

public class QuickFindSet2Test {
    @Test
    public void test01() {
        QuickFindSet2 set = new QuickFindSet2(10);
        for (int i = 0; i < 10; i++) {
            set.set(i, i);
        }

        set.union(0, 1);
        Assert.assertTrue(set.isUnion(0, 1));
        set.union(1, 2);
        Assert.assertTrue(set.isUnion(1, 2));

        Assert.assertTrue(set.isUnion(0, 1));
        set.union(5, 6);
        Assert.assertTrue(set.isUnion(5, 6));
        set.union(6, 7);
        Assert.assertTrue(set.isUnion(6, 7));

        Assert.assertFalse(set.isUnion(2, 7));
        set.union(2, 7);
        Assert.assertTrue(set.isUnion(2, 7));
    }
}