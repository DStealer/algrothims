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
public class IndexMiniHeap<T extends Comparable> {
    private T[] data;
    private int[] heapIndexes;
    private int[] dataIndexes;
    private int count;
    private int capacity;

    public IndexMiniHeap(int capacity, Class<T> clazz) {
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(clazz, capacity);
        this.dataIndexes = new int[capacity];
        this.heapIndexes = new int[capacity];
        this.count = -1;
    }


    public void insert(int i, T t) {
        assert this.count++ < this.capacity;
        this.data[i] = t;
        this.heapIndexes[i] = this.count;
        this.dataIndexes[this.count] = i;
        shiftUp(this.count);
    }

    private void shiftUp(int k) {
        while (k > 0 && this.data[this.dataIndexes[k]].compareTo(this.data[this.dataIndexes[(k - 1) / 2]]) < 0) {
            this.swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        this.heapIndexes[this.dataIndexes[i]] = j;
        this.heapIndexes[this.dataIndexes[j]] = i;

        int t = this.dataIndexes[i];
        this.dataIndexes[i] = this.dataIndexes[j];
        this.dataIndexes[j] = t;

    }

    public void change(int i, T t) {
        assert i < this.capacity;
        assert i > -1;
        this.data[i] = t;

        shiftDown(heapIndexes[i]);
        shiftUp(heapIndexes[i]);
    }

    private void shiftDown(int k) {
        while ((2 * k + 1) <= this.count) {
            int si = 2 * k + 1;
            if (si + 1 < this.count && this.data[this.dataIndexes[si]].compareTo(this.data[this.dataIndexes[si + 1]]) > 0) {
                si = si + 1;
            }
            if (this.data[this.dataIndexes[k]].compareTo(this.data[this.dataIndexes[si]]) < 0) {
                break;
            } else {
                this.swap(k, si);
                k = si;
            }
        }
    }

    public boolean contain(int i) {
        return this.data[i] != null;
    }

    public T min() {
        assert this.count > -1;
        T t = this.data[this.dataIndexes[0]];
        this.data[this.dataIndexes[0]] = null;
        swap(this.count--, 0);
        shiftDown(0);
        return t;
    }

    public int minIndex() {
        assert this.count > -1;
        int t = this.dataIndexes[0];
        this.data[this.dataIndexes[0]] = null;
        swap(this.count--, 0);
        shiftDown(0);
        return t;
    }

    T getMin() {
        assert (count > -1);
        return data[dataIndexes[0]];
    }


    public int size() {
        return this.count + 1;
    }

    int getMinIndex() {
        assert (count > -1);
        return dataIndexes[0];
    }
}
