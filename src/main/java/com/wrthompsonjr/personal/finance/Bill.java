package com.wrthompsonjr.personal.finance;
/*
    -- The Bill Class --
    We all pay Bill's and this is the class that details what a Bill is.
    When a User goes to enter in a Bill they will need to know the Name of the Bill, how much is due,
    the due date of the Bill, and how often the Bill is due.
*/

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Bill {

    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserProfile userProfile;

    private String name;
    private Double cost;
    private String dueDate;
    private String frequency;
    private String subscription;

    public Bill() {
    }

    public Bill(UserProfile userProfile, String name, Double cost, String dueDate, String frequency, String subscription) {
        this.userProfile = userProfile;
        this.name = name;
        this.cost = cost;
        this.dueDate = dueDate;
        this.frequency = frequency;
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getSubscriptionIndicator() {
        return subscription;
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
        return id == ((Bill) obj).id;
    }
}