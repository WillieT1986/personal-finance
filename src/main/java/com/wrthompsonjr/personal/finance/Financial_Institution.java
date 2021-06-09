package com.wrthompsonjr.personal.finance;

public class Financial_Institution {

    public String name;
    public String financialInstitutionType;
    public String accountType;

    public Financial_Institution(String name, String financialInstitutionType, String accountType) {
        this.name = name;
        this.financialInstitutionType = financialInstitutionType;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public String getFinancialInstitutionType() {
        return financialInstitutionType;
    }

    public String getAccountType() {
        return accountType;
    }
}