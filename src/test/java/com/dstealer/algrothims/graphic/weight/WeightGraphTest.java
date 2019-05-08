package com.dstealer.algrothims.graphic.weight;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeightGraphTest {
    WeightGraph g;

    @Before
    public void setUp() throws Exception {
        g = new WeightGraph(8);
        g.addEdge(4, 5, 35);
        g.addEdge(4, 7, 37);
        g.addEdge(5, 7, 28);
        g.addEdge(0, 7, 16);
        g.addEdge(1, 5, 32);
        g.addEdge(0, 4, 38);
        g.addEdge(2, 3, 17);
        g.addEdge(1, 7, 19);
        g.addEdge(0, 2, 26);
        g.addEdge(1, 2, 36);
        g.addEdge(1, 3, 29);
        g.addEdge(2, 7, 34);
        g.addEdge(6, 2, 40);
        g.addEdge(3, 6, 52);
        g.addEdge(6, 0, 58);
        g.addEdge(6, 4, 93);
    }

    @Test
    public void tt01() {
        WeightGraph graph = new WeightGraph(10);
        graph.addEdge(1, 2, 100);
        graph.addEdge(1, 3, 100);
        graph.addEdge(1, 4, 100);
        graph.addEdge(2, 3, 10);
        Assert.assertEquals(graph.edge(), 4);
    }

    @Test
    public void tt02() {
        LazyPrimMST mst = new LazyPrimMST(this.g);
        System.out.println(mst.getWeight());
        System.out.println(mst.getMst());
    }

    @Test
    public void tt03() {
        PrimMST mst = new PrimMST(this.g);
        System.out.println(mst.getWeight());
        System.out.println(mst.getMst());
    }

    @Test
    public void tt04() {
        KruskalMST mst = new KruskalMST(this.g);
        System.out.println(mst.getWeight());
        System.out.println(mst.getMst());
    }

    @Test
    public void tt05() {
        DijkstraST st = new DijkstraST(this.g, 0);
    }
}