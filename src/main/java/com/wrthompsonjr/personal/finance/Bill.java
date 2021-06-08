package com.wrthompsonjr.personal.finance;

public class Bill {

    private String name;
    private Double cost;
    private String dueDate;

    public Bill(String name, Double cost, String dueDate) {
        this.name = name;
        this.cost = cost;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getDueDate() {
        return dueDate;
    }
}