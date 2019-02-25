package com.dstealer.algrothims.struct;

import com.dstealer.algrothims.common.Assistant;

/**
 * 索引数据堆,0-base
 * k
 * \   \
 * \     \
 * 2k+1 2k+2
 * <p>
 * (k-1)/2 是父节点
 */
public class IndexDataHeaq {
    private int[] data;
    private int[] index;
    private int position;
    private int capacity;


    public IndexDataHeaq(int capacity) {
        this.data = new int[capacity];
        this.index = new int[capacity];
        this.capacity = capacity;
        this.position = -1;
    }

    /**
     * 堆当前大小
     *
     * @return
     */
    public int size() {
        return this.position + 1;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.position == -1;
    }

    /**
     * 插入数据
     *
     * @param index
     * @param item
     */
    public void insert(int index, int item) {
        if (this.position >= this.capacity) {
            throw new IndexOutOfBoundsException();
        }
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        this.index[this.position++] = index;
        this.data[index] = item;

        shiftUp(this.position);
    }

    public int extractMaxIndex() {
        if (this.position <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int ret = this.index[0];
        Assistant.swapInt(this.index, 0, this.position);
        this.position--;
        this.shiftDown(0);
        return ret;
    }

    public int getMaxItem(int index) {
        return this.data[this.index[index]];
    }

    /**
     * @param i    在堆中的位置
     * @param item 数据
     */
    public void change(int i, int item) {
        data[i] = item;
        for (int j = 0; j <= this.position; j++) {
            if (this.index[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }


    private void shiftUp(int pos) {
        while (pos > 0 && this.data[(this.index[pos] - 1) / 2] < this.data[this.index[pos]]) {
            Assistant.swapInt(this.index, pos, (pos - 1) / 2);
            pos = (pos - 1) / 2;
        }
    }

    private void shiftDown(int pos) {
        while (2 * pos + 1 <= this.position) {
            //决定子节点中的最大者
            int leftNode = 2 * pos + 1;
            int rightNode = 2 * pos + 2;

            int maxNode = leftNode;

            if (rightNode <= this.position && this.data[this.index[leftNode]] < this.data[this.data[rightNode]]) {
                maxNode = rightNode;
            }
            if (this.data[this.index[pos]] >= this.data[this.index[maxNode]]) {
                break;
            }
            Assistant.swapInt(this.index, pos, maxNode);
            pos = maxNode;
        }

    }

}
