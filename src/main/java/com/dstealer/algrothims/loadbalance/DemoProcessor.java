package com.dstealer.algrothims.loadbalance;

import java.security.InvalidParameterException;

public class DemoProcessor implements Processor {
    private String name;
    private int weight;

    public DemoProcessor(String name, int weight) {
        this.name = name;
        if (weight < 1 || weight > 10) {
            throw new InvalidParameterException();
        }
        this.weight = weight;
    }

    public void process(Object exchange) throws Exception {

    }

    public int getWeight() {
        return this.weight;
    }
}
