package com.dstealer.algrothims.graphic;

import org.junit.Assert;
import org.junit.Test;

public class DenseGraphTest {

    @Test
    public void addEdge() {
        DenseGraph graph = new DenseGraph(10, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        Assert.assertEquals(3, graph.getEdge());
        graph.addEdge(2, 3);
        Assert.assertEquals(3, graph.getEdge());
        graph.print();
        Assert.assertArrayEquals(new int[]{2}, graph.visitEdge(1));
    }

    @Test
    public void show() {
        DenseGraph g1 = GraphData.getDenseDirectedGraph();
        g1.print();

        DenseGraph g2 = GraphData.getDenseUndirectedGraph();
        g2.print();
    }
}