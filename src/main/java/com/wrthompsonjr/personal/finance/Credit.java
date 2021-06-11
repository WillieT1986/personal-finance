package com.wrthompsonjr.personal.finance;

public class Credit {

    public String creditName;
    public String creditType;
    public Double creditAmount;
    public String creditIssuer;
    public String creditDateReceived;
    public String creditDueDate;

    public Credit(String creditName, String creditType, Double creditAmount, String creditIssuer, String creditDateReceived, String creditDueDate) {
        this.creditName = creditName;
        this.creditType = creditType;
        this.creditAmount = creditAmount;
        this.creditIssuer = creditIssuer;
        this.creditDateReceived = creditDateReceived;
        this.creditDueDate = creditDueDate;
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

    public String getCreditReceivedDate() {
        return creditDateReceived;
    }

    public String getCreditDueDate() {
        return creditDueDate;
    }
}