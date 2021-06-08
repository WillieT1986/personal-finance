package com.wrthompsonjr.personal.finance;

public class Bill {

    private String name;
    private Double cost;

    public Bill(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }
}