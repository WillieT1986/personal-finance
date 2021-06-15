package com.wrthompsonjr.personal.finance;
/*
    -- The Income Class --
    A user will usually have only one source of income but for those who have multiple sources, or
    share/split their income with a significant other should be tracked to.
    Example: User has 2x Sources of Income while possibly having access, or balancing the income
    for another user as well.
*/

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Income {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "income")
    private Collection<UserProfile> userProfiles;

    public String source;
    public Double amount;
    public String dateReceived;
    public String incomeFrequency;

    public Income() {
    }

    public Income(String source, Double amount, String dateReceived, String incomeFrequency) {
        this.source = source;
        this.amount = amount;
        this.dateReceived = dateReceived;
        this.incomeFrequency = incomeFrequency;
    }

    public Collection<UserProfile> getUserProfiles() {
        return userProfiles;
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
        return id == ((Income) obj).id;
    }
}