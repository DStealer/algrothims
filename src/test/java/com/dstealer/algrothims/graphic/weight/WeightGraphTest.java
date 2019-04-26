package com.dstealer.algrothims.graphic.weight;

import org.junit.Assert;
import org.junit.Test;

public class WeightGraphTest {
    @Test
    public void tt01() {
        WeightGraph graph = new WeightGraph(10);
        graph.addEdge(1, 2, 100);
        graph.addEdge(1, 3, 100);
        graph.addEdge(1, 4, 100);
        graph.addEdge(2, 3, 10);
        Assert.assertEquals(graph.edge(), 4);
    }
}