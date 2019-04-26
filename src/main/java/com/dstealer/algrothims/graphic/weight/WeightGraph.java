package com.dstealer.algrothims.graphic.weight;

import java.util.Vector;

public class WeightGraph {
    private int node, edge;
    private Vector<Vector<Weight>> g;

    public WeightGraph(int node) {
        this.node = node;
        this.edge = 0;
        this.g = new Vector<>();
        for (int i = 0; i < this.node; i++) {
            this.g.add(new Vector<>());
        }
    }

    public int node() {
        return this.node;
    }

    public int edge() {
        return this.edge;
    }

    public void addEdge(int v, int w, int weight) {
        assert (v >= 0 && v < this.node);
        assert (w >= 0 && w < this.node);
        this.edge++;
        Weight wg = new Weight(v, w, weight);
        this.g.get(v).add(wg);
        this.g.get(w).add(wg);
    }

    public Vector<Weight> visit(int x) {
        return this.g.get(x);
    }
}
