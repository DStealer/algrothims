package com.dstealer.algrothims;

import org.junit.After;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static final ThreadLocal<Long> time = new ThreadLocal<>();

    @Before
    public void setUp() throws Exception {
        time.set(System.nanoTime());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Time eclipsing: " + (System.nanoTime() - time.get()) + " ns");
    }
}
