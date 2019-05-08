package com.dstealer.algrothims.graphic.weight;

/**
 * 单源最短路径
 */
public class DijkstraST {
    private WeightGraph g;
    private int s;
    private IndexMiniHeap<Integer> heap;
    private boolean[] marked;
    private Edge[] path;
    private int[] sswtn;

    public DijkstraST(WeightGraph g, int s) {
        this.g = g;
        this.s = s;
        this.heap = new IndexMiniHeap<>(this.g.node(), Integer.class);
        this.marked = new boolean[this.g.node()];
        this.path = new Edge[this.g.node()];
        this.sswtn = new int[this.g.node()];


        this.sswtn[s] = 0;
        this.marked[s] = true;
        this.heap.insert(s, 0);

        while (this.heap.size() > 0) {
            int v = heap.minIndex();
            this.marked[v] = true;

            for (Edge edge : this.g.visit(v)) {
                int w = edge.other(v);
                if (!marked[w]) {
                    if (this.path[w] == null || this.sswtn[v] + edge.getWeight() < this.sswtn[w]) {
                        this.sswtn[w] = this.sswtn[v] + edge.getWeight();
                        this.path[w] = edge;
                        if (this.heap.contain(w)) {
                            this.heap.insert(w, this.sswtn[w]);
                        } else {
                            this.heap.change(w, this.sswtn[w]);
                        }
                    }
                }
            }

        }

    }

    public int shortestPathTo(int w) {
        assert (w >= 0 && w < this.g.node());
        return this.sswtn[w];
    }

    public void show(int w) {
        assert (w >= 0 && w < this.g.node());

    }
}
