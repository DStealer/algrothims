package com.dstealer.algrothims.graphic;

import java.util.Vector;

/**
 * 稀疏图 使用邻接表实现
 */
public class SparseGraph {
    private int n, m;
    private Vector<Vector<Integer>> g;
    private boolean directed;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.g = new Vector<>(n);
        this.directed = directed;
        for (int i = 0; i < this.n; i++) {
            this.g.add(new Vector<>());
        }
    }

    public void addEdge(int x, int y) {
        assert x >= 0 && x < this.n;
        assert y >= 0 && y < this.n;

        if (hasEdge(x, y)) {
            return;
        }
        if (this.directed) {
            this.g.get(x).add(y);
            this.m++;
        } else {
            this.g.get(x).add(y);
            this.g.get(y).add(x);
            this.m++;
        }
    }

    public boolean hasEdge(int x, int y) {
        assert x >= 0 && x < this.n;
        assert y >= 0 && y < this.n;
        for (int i = 0, len = this.g.get(x).size(); i < len; i++) {
            if (this.g.get(x).get(i).equals(y)) {
                return true;
            }
        }
        return false;
    }

    public int getEdge() {
        return this.m;
    }

    public void print() {
        for (int i = 0; i < this.n; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < this.g.get(i).size(); j++) {
                System.out.print("\t" + this.g.get(i).get(j));
            }
            System.out.print("\n");
        }
    }

    public Vector<Integer> visit(int x) {
        assert x >= 0 && x < this.n;
        return this.g.get(x);
    }
}
