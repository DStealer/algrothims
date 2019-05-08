package com.dstealer.algrothims.graphic.weight;

import org.junit.Test;

import java.util.Random;

public class MiniHeapTest {
    @Test
    public void tt01() {
        MiniHeap<Edge> heap = new MiniHeap<>(10, Edge.class);
        for (int i = 0; i < 10; i++) {
            heap.insert(new Edge(1, 1, new Random().nextInt(100)));
        }
        while (heap.size() > 0) {
            System.out.println(heap.min());
        }
    }
}