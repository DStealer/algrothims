package com.dstealer.algrothims.graphic.weight;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private final int a, b;
    private final int weight;

    public Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int other(int x) {
        return this.a == x ? this.b : this.a;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a + b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (a == edge.a && b == edge.b) || (a == edge.b && b == edge.a);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
