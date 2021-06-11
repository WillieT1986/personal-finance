package com.wrthompsonjr.personal.finance;

public class Credit {

    public String creditName;
    public String creditType;
    public Double creditAmount;

    public Credit(String creditName, String creditType, Double creditAmount) {
        this.creditName = creditName;
        this.creditType = creditType;
        this.creditAmount = creditAmount;
    }

    public String getCreditName() {
        return creditName;
    }

    public String getCreditType() {
        return creditType;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }
}