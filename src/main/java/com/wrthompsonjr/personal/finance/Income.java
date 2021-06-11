package com.wrthompsonjr.personal.finance;

public class Income {

    public String source;
    private Double amount;

    public Income(String source, Double amount) {
        this.source = source;
        this.amount = amount;
    }

    public String getSourceOfIncome() {
        return source;
    }

    public Double getIncomeAmount() {
        return amount;
    }
}