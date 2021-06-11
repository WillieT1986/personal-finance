package com.wrthompsonjr.personal.finance;

public class Credit {

    public String creditName;
    public String creditType;

    public Credit(String creditName, String creditType) {
        this.creditName = creditName;
        this.creditType = creditType;
    }

    public String getCreditName() {
        return creditName;
    }

    public String getCreditType() {
        return creditType;
    }
}