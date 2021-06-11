package com.wrthompsonjr.personal.finance;

public class Credit {

    public String creditName;
    public String creditType;
    public Double creditAmount;
    public String creditIssuer;

    public Credit(String creditName, String creditType, Double creditAmount, String creditIssuer) {
        this.creditName = creditName;
        this.creditType = creditType;
        this.creditAmount = creditAmount;
        this.creditIssuer = creditIssuer;
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

    public String getCreditIssuer() {
        return creditIssuer;
    }
}