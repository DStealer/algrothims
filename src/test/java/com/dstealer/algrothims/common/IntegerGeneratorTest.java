package com.dstealer.algrothims.common;

import org.junit.Test;

public class IntegerGeneratorTest {
    @Test
    public void tt01() {
        IntegerGenerator generator = new IntegerGenerator(100);
        try {
            while (true) {
                System.out.println(generator.gen());
            }
        } catch (IntegerGenerator.StopIteration stopIteration) {
            //swallow
        }
    }
}