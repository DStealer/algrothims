package com.dstealer.algrothims.recursion;

import org.junit.Assert;
import org.junit.Test;

public class ReversingStringTest {

    @Test
    public void reserve() {
        Assert.assertEquals("a", ReversingString.reserve("a"));
        Assert.assertEquals("ba", ReversingString.reserve("ab"));
        Assert.assertEquals("cba", ReversingString.reserve("abc"));
        Assert.assertEquals("dcba", ReversingString.reserve("abcd"));
    }

    @Test
    public void reserveNonEmpty() {
        Assert.assertEquals("a", ReversingString.reserveNonEmpty("a"));
        Assert.assertEquals("ab", ReversingString.reserveNonEmpty("ba"));
        Assert.assertEquals("abc", ReversingString.reserveNonEmpty("cba"));
        Assert.assertEquals(" a", ReversingString.reserveNonEmpty(" a"));
        Assert.assertEquals(" ab", ReversingString.reserveNonEmpty(" ba"));
        Assert.assertEquals(" a b c ", ReversingString.reserveNonEmpty(" a b c "));
        Assert.assertEquals(" ab bc cd ", ReversingString.reserveNonEmpty(" ba cb dc "));
    }
}