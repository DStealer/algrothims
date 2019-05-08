package com.dstealer.algrothims.graphic.weight;

import java.util.Vector;

public class KruskalMST {
    private MiniHeap<Edge> heap;
    private WeightGraph g;
    private Vector<Edge> mst;
    private int weight;


    public KruskalMST(WeightGraph g) {
        this.g = g;
        this.heap = new MiniHeap<>(g.edge(), Edge.class);
        this.mst = new Vector<>(g.node() - 1);
        this.weight = 0;
        for (int i = 0; i < this.g.node(); i++) {
            for (Edge edge : this.g.visit(i)) {
                if (edge.a() < edge.b()) {
                    this.heap.insert(edge);
                }
            }
        }

        UnionFind uf = new UnionFind(this.g.node());

        while (this.heap.size() > 0 && this.mst.size() < this.g.node() - 1) {
            Edge e = this.heap.min();
            if (uf.isUnion(e.a(), e.b())) {
                continue;
            } else {
                uf.union(e.a(), e.b());
                mst.add(e);
            }
        }

        for (Edge edge : this.mst) {
            this.weight += edge.getWeight();
        }
    }

    public Vector<Edge> getMst() {
        return mst;
    }

    public int getWeight() {
        return weight;
    }
}
