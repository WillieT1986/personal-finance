package com.wrthompsonjr.personal.finance;
/*
    -- The Financial Institution Class --
    Everyone belongs to some type of Financial Institution.
    Whether it is a Bank, Credit Union, or even a Crypto Exchange, we hold our funds in some type of account.
    It's either a Checking Account, Savings Account, Retirement Account, or even a Crypto Wallet.
    When a User goes to enter in their Financial Institution, they will only need to add in the Name, Type,
    and Account Type.
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Financial_Institution {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "financialInstitution")
    private Collection<UserProfile> userProfiles;

    public String name;
    public String financialInstitutionType;
    public String accountType;

    public Financial_Institution() {
    }

    public Financial_Institution(String name, String financialInstitutionType, String accountType) {
        this.name = name;
        this.financialInstitutionType = financialInstitutionType;
        this.accountType = accountType;
    }


    public Collection<UserProfile> getUserProfiles() {
        return userProfiles;
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

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return id == ((Financial_Institution) obj).id;
    }
}