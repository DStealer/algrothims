package com.dstealer.algrothims.graphic.weight;

import org.junit.Test;

public class IndexMiniHeapTest {
    @Test
    public void tt01() {
        IndexMiniHeap<Integer> heap = new IndexMiniHeap<>(10, Integer.class);
        for (int i = 0; i < 10; i++) {
            heap.insert(i, 5 - i);
        }
        heap.change(5, 100);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -> " + heap.getMinIndex() + "=" + heap.min());
        }
    }
}