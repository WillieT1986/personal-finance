package com.wrthompsonjr.personal.finance;

public class Bill {

    private String name;
    private Double cost;
    private String dueDate;
    private String frequency;

    public Bill(String name, Double cost, String dueDate, String frequency) {
        this.name = name;
        this.cost = cost;
        this.dueDate = dueDate;
        this.frequency = frequency;
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

    public String getFrequency() {
        return frequency;
    }
}