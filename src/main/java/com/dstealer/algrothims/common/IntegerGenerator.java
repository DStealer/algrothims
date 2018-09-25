package com.dstealer.algrothims.common;

import java.util.Random;

public class IntegerGenerator {
    private final int capacity;
    private final Random random;
    private final int baseFrom;
    private final int offset;
    private int cur;

    /**
     * @param capacity
     * @param rangeL   include
     * @param rangeR   exclude
     */
    public IntegerGenerator(int capacity, int rangeL, int rangeR) {
        this.capacity = capacity;
        this.random = new Random();
        this.baseFrom = rangeL;
        this.offset = rangeR - rangeL;
    }

    public IntegerGenerator(int capacity) {
        this(capacity, 1, Integer.MAX_VALUE);
    }

    public int gen() throws StopIteration {
        if (this.cur++ < this.capacity) {
            return this.random.nextInt(this.offset) + this.baseFrom;
        } else {
            throw new StopIteration();
        }
    }

    public int size() {
        return this.capacity;
    }

    public class StopIteration extends Exception {
        public StopIteration() {
            super("stop normal", null, true, false);
        }
    }
}
