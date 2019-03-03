package com.dstealer.algrothims.graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 使用邻接矩阵实现
 */
public class DenseGraph {
    private int n, m;//节点数 边数
    private boolean[][] g;
    private boolean directed;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new boolean[n][n];
    }

    public void addEdge(int x, int y) {
        assert x >= 0 && x < this.n;
        assert y >= 0 && y < this.n;
        if (hasEdge(x, y)) {
            return;
        }
        if (this.directed) {
            this.g[x][y] = true;
            this.m++;
        } else {
            this.g[x][y] = true;
            this.g[y][x] = true;
            this.m++;
        }
    }

    /**
     * o(1)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean hasEdge(int x, int y) {
        return this.g[x][y];
    }

    public int getEdge() {
        return this.m;
    }

    public void print() {
        System.out.print("\t");
        for (int i = 0; i < this.n; i++) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");
        for (int i = 0; i < this.n; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < this.n; j++) {
                if (this.g[i][j]) {
                    System.out.print(1 + "\t");
                } else {
                    System.out.print(0 + "\t");
                }
            }
            System.out.print("\n");
        }
    }

    public int[] visitEdge(int x) {
        assert x >= 0 && x < this.n;
        List<Integer> edges = new ArrayList<>();
        for (int i = 0; i < this.n; i++) {
            if (this.g[x][i]) {
                edges.add(i);
            }
        }
        int[] edgeArr = new int[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            edgeArr[i] = edges.get(i);
        }
        return edgeArr;
    }
}