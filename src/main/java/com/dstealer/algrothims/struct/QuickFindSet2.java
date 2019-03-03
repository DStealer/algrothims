package com.dstealer.algrothims.struct;

/**
 * 快速查询的并查集 优化版
 * 查询速度和并集树的高度有关系
 * 特征：
 * 无论如何总会有一个根
 * 相同的并集有相同的根
 */
public class QuickFindSet2 {
    private int[] parents;

    public QuickFindSet2(int size) {
        this.parents = new int[size];
    }

    public void set(int index, int num) {
        assert index >= 0 && index < this.parents.length;
        this.parents[index] = num;
    }

    public void union(int indexA, int indexB) {
        assert indexA >= 0 && indexA < this.parents.length;
        assert indexB >= 0 && indexB < this.parents.length;

        int rootA = find(indexA);
        int rootB = find(indexB);
        if (rootA != rootB) {
            this.parents[rootB] = this.parents[rootA]; //将B挂在到A上
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
