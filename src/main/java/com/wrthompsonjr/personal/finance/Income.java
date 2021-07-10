package com.wrthompsonjr.personal.finance;
/*
    -- The Income Class --
    A user will usually have only one source of income but for those who have multiple sources, or
    share/split their income with a significant other should be tracked to.
    Example: User has 2x Sources of Income while possibly having access, or balancing the income
    for another user as well.
*/

import net.minidev.json.annotate.JsonIgnore;
import javax.persistence.*;

@Entity
public class Income {

    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserProfile userProfile;

    public String source;
    public Double amount;
    public String dateReceived;
    public String incomeFrequency;

    public Income() {
    }

    public Income(String source, Double amount, String dateReceived, String incomeFrequency, UserProfile userProfile) {
        this.source = source;
        this.amount = amount;
        this.dateReceived = dateReceived;
        this.incomeFrequency = incomeFrequency;
        this.userProfile = userProfile;
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