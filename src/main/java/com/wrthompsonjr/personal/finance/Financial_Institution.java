package com.wrthompsonjr.personal.finance;

public class Financial_Institution {

    public String name;
    public String financial_institution_type;
    public String accountType;

    public Financial_Institution(String name, String financial_institution_type, String accountType) {
        this.name = name;
        this.financial_institution_type = financial_institution_type;
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public String getFinancialInstitutionType() {
        return financial_institution_type;
    }

    public String getAccountType() {
        return accountType;
    }
}