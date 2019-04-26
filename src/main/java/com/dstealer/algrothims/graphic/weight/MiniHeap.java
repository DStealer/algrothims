package com.dstealer.algrothims.graphic.weight;

import java.lang.reflect.Array;

/**
 * 0 base的最小堆
 * k
 * 2k+1 , 2k+2
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class MiniHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;

    public MiniHeap(int capacity, Class<T> clazz) {
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(clazz, capacity);
        this.count = -1;
    }

    public int size() {
        return this.count + 1;
    }

    public void insert(T t) {
        assert this.count++ < this.capacity;
        this.data[this.count] = t;
        shiftUp(this.count);
    }

    private void shiftUp(int k) {
        while (k > 0 && this.data[k].compareTo(this.data[(k - 1) / 2]) < 0) {
            this.swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        T t = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = t;
    }

    public T min() {
        assert this.count > -1;
        T t = this.data[0];
        swap(this.count--, 0);
        shiftDown(0);
        return t;
    }

    private void shiftDown(int k) {
        while ((2 * k + 1) < this.count) {
            int si = 2 * k + 1;
            if (si + 1 < this.count && this.data[si].compareTo(this.data[si + 1]) > 0) {
                si = si + 1;
            }
            if (this.data[k].compareTo(this.data[si]) < 0) {
                break;
            } else {
                this.swap(k, si);
                k = si;
            }
        }
    }
}
