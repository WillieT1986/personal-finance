package com.wrthompsonjr.personal.finance;
/*
    -- The Financial Institution Class --
    Everyone belongs to some type of Financial Institution.
    Whether it is a Bank, Credit Union, or even a Crypto Exchange, we hold our funds in some type of account.
    It's either a Checking Account, Savings Account, Retirement Account, or even a Crypto Wallet.
    When a User goes to enter in their Financial Institution, they will only need to add in the Name, Type,
    and Account Type.
*/

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