package com.dstealer.algrothims.struct;

/**
 * 快速查询的并查集
 * 查询O(1)级别
 * 特征：相同并拥有相同的level
 */
public class QuickFindSet {
    private int[] parents;

    public QuickFindSet(int size) {
        this.parents = new int[size];
    }

    public void set(int index, int num) {
        assert index >= 0 && index < this.parents.length;
        this.parents[index] = num;
    }

    public void union(int indexA, int indexB) {
        assert indexA >= 0 && indexA < this.parents.length;
        assert indexB >= 0 && indexB < this.parents.length;

        int statA = find(indexA);
        int statB = find(indexB);
        if (statA == statB) {
            return;
        }

        for (int i = 0; i < this.parents.length; i++) {
            if (this.parents[i] == statA) {
                this.parents[i] = statB;
            }
        }
    }

    public int find(int index) {
        assert index >= 0 && index < this.parents.length;
        return this.parents[index];
    }

    public boolean isUnion(int indexA, int indexB) {
        assert indexA >= 0 && indexA < this.parents.length;
        assert indexB >= 0 && indexB < this.parents.length;
        return this.parents[indexA] == this.parents[indexB];
    }
}
