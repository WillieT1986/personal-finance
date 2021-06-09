package com.wrthompsonjr.personal.finance;

public class Financial_Institution {

    public String name;
    public String financial_institution_type;

    public Financial_Institution(String name, String financial_institution_type) {
        this.name = name;
        this.financial_institution_type = financial_institution_type;
    }

    public String getName() {
        return name;
    }

    public String getFinancialInstitutionType() {
        return financial_institution_type;
    }
}