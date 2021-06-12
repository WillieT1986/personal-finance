package com.wrthompsonjr.personal.finance;
/*
    -- The Income Class --
    A user will usually have only one source of income but for those who have multiple sources, or
    share/split their income with a significant other should be tracked to.
    Example: User has 2x Sources of Income while possibly having access, or balancing the income
    for another user as well.
*/

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