package com.wrthompsonjr.personal.finance;
/*
    -- The Credit Class --
    Everyone has Credit in one way shape of form.
    Whether it be a Credit Card, a Charge Card, or even a Loan. This is to help manage it better without
    sacrificing security and making our Credit more vulnerable online. Instead of adding Credit Info,
    this just helps track the basics.
*/

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Credit {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "credit")
    private Collection<UserProfile> userProfiles;

    public String creditName;
    public String creditType;
    public Double creditAmount;
    public String creditIssuer;
    public String creditDateReceived;
    public String creditDueDate;

    public Credit() {
    }

    public Credit(String creditName, String creditType, Double creditAmount, String creditIssuer, String creditDateReceived, String creditDueDate) {
        this.creditName = creditName;
        this.creditType = creditType;
        this.creditAmount = creditAmount;
        this.creditIssuer = creditIssuer;
        this.creditDateReceived = creditDateReceived;
        this.creditDueDate = creditDueDate;
    }

    public Collection<UserProfile> getUserProfiles() {
        return userProfiles;
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
        return id == ((Credit) obj).id;
    }
}