package com.wrthompsonjr.personal.finance;

public class Income {

    public String source;
    public Double amount;
    public String dateReceived;
    public String incomeFrequency;

    public Income(String source, Double amount, String dateReceived, String incomeFrequency) {
        this.source = source;
        this.amount = amount;
        this.dateReceived = dateReceived;
        this.incomeFrequency = incomeFrequency;
    }

    public String getSourceOfIncome() {
        return source;
    }

    public Double getIncomeAmount() {
        return amount;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public String getIncomeFrequency() {
        return incomeFrequency;
    }
}