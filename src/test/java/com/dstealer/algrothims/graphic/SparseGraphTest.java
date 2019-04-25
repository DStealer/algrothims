package com.dstealer.algrothims.graphic;

import org.junit.Assert;
import org.junit.Test;

public class SparseGraphTest {

    @Test
    public void addEdge() {
        SparseGraph graph = new SparseGraph(10, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        Assert.assertEquals(3, graph.getEdge());
        graph.addEdge(2, 3);
        Assert.assertEquals(3, graph.getEdge());
        graph.print();
        Assert.assertEquals(1, graph.visit(0).size());
        Assert.assertEquals(Integer.valueOf(1), graph.visit(0).get(0));
    }

    @Test
    public void show() {
        SparseGraph g1 = GraphData.getSparsedirectedGraph();
        g1.print();
        SparseGraph g2 = GraphData.getSparseUndirectedGraph();
        g2.print();
    }

    @Test
    public void dfs() {
        SparseGraph g1 = GraphData.getSparsedirectedGraph();
        g1.print();
        g1.dfs();
    }

    @Test
    public void bfs() {
        SparseGraph g1 = GraphData.getSparsedirectedGraph();
        g1.print();
        g1.bfs();
    }
}