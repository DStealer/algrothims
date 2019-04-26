package com.dstealer.algrothims.graphic.weight;

public class Weight implements Comparable<Weight> {
    private final int a, b;
    private final int weight;

    public Weight(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int other(int x) {
        return this.a == x ? this.b : this.a;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Weight o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }
}
