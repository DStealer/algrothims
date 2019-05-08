package com.dstealer.algrothims.graphic.weight;

import java.util.Arrays;
import java.util.Vector;

/**
 * 最小生成树
 */
public class PrimMST {
    private boolean[] marked;
    private Edge[] edges;
    private WeightGraph g;
    private Vector<Edge> mst;
    private int weight;
    private IndexMiniHeap<Edge> miniHeap;

    public PrimMST(WeightGraph g) {
        this.g = g;
        this.marked = new boolean[g.node()];
        this.edges = new Edge[g.node()];

        this.mst = new Vector<>(g.node() - 1);
        this.weight = 0;
        this.miniHeap = new IndexMiniHeap<>(g.edge(), Edge.class);

        visit(0);
        while (miniHeap.size() != 0) {
            int v = miniHeap.minIndex();
            assert this.edges[v] != null;
            mst.add(this.edges[v]);
            visit(v);
        }
        for (Edge edge : this.mst) {
            this.weight += edge.getWeight();
        }
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge w : this.g.visit(v)) {
            int x = w.other(v);
            if (!marked[x]) {
                if (this.edges[x] == null) {
                    this.edges[x] = w;
                    this.miniHeap.insert(x, w);
                } else if (w.getWeight() < this.edges[x].getWeight()) {
                    this.edges[x] = w;
                    this.miniHeap.change(x, w);
                }
            }
        }
        System.out.println("visit:" + v + " => " + Arrays.toString(this.edges));
    }

    public Vector<Edge> getMst() {
        return mst;
    }

    public int getWeight() {
        return weight;
    }
}
