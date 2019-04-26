package com.dstealer.algrothims.graphic.weight;

import org.junit.Test;

import java.util.Random;

public class MiniHeapTest {
    @Test
    public void tt01() {
        MiniHeap<Weight> heap = new MiniHeap<>(100, Weight.class);
        for (int i = 0; i < 100; i++) {
            heap.insert(new Weight(1, 1, new Random().nextInt(100)));
        }
        while (heap.size() > 0) {
            System.out.println(heap.min());
        }
    }
}