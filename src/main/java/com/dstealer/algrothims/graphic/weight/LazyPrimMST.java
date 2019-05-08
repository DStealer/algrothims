package com.dstealer.algrothims.graphic.weight;

import java.util.Vector;

/**
 * 最小生成树
 */
public class LazyPrimMST {
    private boolean[] marked;
    private WeightGraph g;
    private Vector<Edge> mst;
    private int weight;
    private MiniHeap<Edge> miniHeap;

    public LazyPrimMST(WeightGraph g) {
        this.g = g;
        this.marked = new boolean[g.node()];
        this.mst = new Vector<>(g.node() - 1);
        this.weight = 0;
        this.miniHeap = new MiniHeap<>(g.edge(), Edge.class);

        visit(0);
        while (miniHeap.size() != 0) {
            Edge e = miniHeap.min();
            if (marked[e.a()] == marked[e.b()]) {
                continue;
            }
            mst.add(e);
            if (!marked[e.a()]) {
                visit(e.a());
            } else {
                visit(e.b());
            }

        }
        for (Edge edge : this.mst) {
            this.weight += edge.getWeight();
        }
    }

    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge w : this.g.visit(v)) {
            if (!marked[w.other(v)]) {
                miniHeap.insert(w);
            }
        }
    }

    public Vector<Edge> getMst() {
        return mst;
    }

    public int getWeight() {
        return weight;
    }
}
