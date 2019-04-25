package com.dstealer.algrothims.graphic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if (directed) {
            return this.g[x][y];
        } else {
            return this.g[x][y] || this.g[y][x];
        }
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

    //深度优先遍历
    public void dfs() {
        boolean[] visited = new boolean[this.n];
        int count = 0;
        for (int i = 0; i < this.n; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        System.out.println("联通分量:" + count);
    }

    private void dfs(int x, boolean[] visited) {
        visited[x] = true;
        System.out.println("visit:" + x);
        for (int i = 0; i < this.n; i++) {
            if (this.g[x][i] && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    //广度优先遍历
    public void bfs() {
        boolean[] visited = new boolean[this.n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.n; i++) {
            if (!visited[i]) {
                bfs(i, visited, queue);
            }
        }
    }

    private void bfs(int x, boolean[] visited, Queue<Integer> queue) {
        queue.add(x);
        visited[x] = true;
        System.out.println("visit:" + x);
        while (!queue.isEmpty()) {
            Integer y = queue.poll();
            for (int i = 0; i < this.n; i++) {
                if (this.g[y][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.println("visit:" + i);
                }
            }
        }
    }
}