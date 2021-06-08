package com.wrthompsonjr.personal.finance;
/*
    -- The Bill Class --
    We all pay Bill's and this is the class that details what a Bill is.
    When a User goes to enter in a Bill they will need to know the Name of the Bill, how much is due,
    the due date of the Bill, and how often the Bill is due.
*/
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