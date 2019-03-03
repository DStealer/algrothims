package com.dstealer.algrothims.struct;

/**
 * 快速查询的并查集 优化版
 * 查询速度和并集树的高度有关系
 * 特征：
 * 无论如何总会有一个根
 * 相同的并集有相同的根
 * 优化根的高度(根据根拥有的元素数量)
 */
public class QuickFindSet3 {
    private int[] parents;
    private int[] size; //每个以此为根节点的元素数量

    public QuickFindSet3(int size) {
        this.parents = new int[size];
        this.size = new int[size];
    }

    public void set(int index, int num) {
        assert index >= 0 && index < this.parents.length;
        this.parents[index] = num;
        this.size[index] = 1;
    }

    public void union(int indexA, int indexB) {
        assert indexA >= 0 && indexA < this.parents.length;
        assert indexB >= 0 && indexB < this.parents.length;

        int rootA = find(indexA);
        int rootB = find(indexB);

        if (rootA == rootB) {
            return;
        }

        if (this.size[rootA] < this.size[rootB]) { // 将少的挂在到多的上面 ，即将B的root id指向A的root id
            this.parents[rootA] = rootB;
            this.size[rootB] += this.size[rootA];
        } else {
            this.parents[rootB] = rootA;
            this.size[rootA] += this.size[rootB];
        }
    }

    /**
     * 需要查询到根结点
     *
     * @param index
     * @return
     */
    public int find(int index) {
        assert index >= 0 && index < this.parents.length;
        while (index != this.parents[index]) {
            index = this.parents[index];
        }
        return index;
    }

    public int findLevel(int index) {
        return this.size[index];
    }

    /**
     * 查询根结点的level
     *
     * @param indexA
     * @param indexB
     * @return
     */
    public boolean isUnion(int indexA, int indexB) {
        assert indexA >= 0 && indexA < this.parents.length;
        assert indexB >= 0 && indexB < this.parents.length;

        int rootA = find(indexA);
        int rootB = find(indexB);

        return this.parents[rootA] == this.parents[rootB];
    }
}
