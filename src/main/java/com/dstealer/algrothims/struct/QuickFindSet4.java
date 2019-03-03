package com.dstealer.algrothims.struct;

/**
 * 快速查询的并查集 优化版
 * 查询速度和并集树的高度有关系
 * 特征：
 * 无论如何总会有一个根
 * 相同的并集有相同的根
 * 优化根的高度(根据根的rank)
 */
public class QuickFindSet4 {
    private int[] parents;
    private int[] rank; //每个以此为根节点高度

    public QuickFindSet4(int size) {
        this.parents = new int[size];
        this.rank = new int[size];
    }

    public void set(int index, int num) {
        assert index >= 0 && index < this.parents.length;
        this.parents[index] = num;
        this.rank[index] = 1;
    }

    public void union(int indexA, int indexB) {
        assert indexA >= 0 && indexA < this.parents.length;
        assert indexB >= 0 && indexB < this.parents.length;

        int rootA = find(indexA);
        int rootB = find(indexB);

        if (rootA == rootB) {
            return;
        }
        if (this.rank[rootA] > this.rank[rootB]) { //rootA 的 rank 大于 rootB 的rank 将B的根指向A
            this.parents[rootB] = rootA;
        } else if (this.rank[rootA] < this.rank[rootB]) {
            this.parents[rootA] = rootB;
        } else {
            this.parents[rootB] = rootA;
            this.rank[rootA] = this.rank[rootA] + 1;
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

    public int findRank(int index) {
        return this.rank[index];
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
