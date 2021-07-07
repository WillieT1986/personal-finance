package com.wrthompsonjr.personal.finance;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

/*
    -- The User Profile Class --
    This is where all the info for the User Profile will be stored, and have all other data tied to it.
    At least, in theory anyways...
*/

@Entity
public class UserProfile {

    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bill bill;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Income income;

    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public String userEmail;
    public String userPhoneNumber;

    public UserProfile() {
    }

    public UserProfile(String firstName, String middleName, String lastName, String suffix, String userEmail, String userPhoneNumber,
                       Bill bill, Income income) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.bill = bill;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public String getUserFirstName() {
        return firstName;
    }

    public String getUserMiddleName() {
        return middleName;
    }

    public String getUserLastName() {
        return lastName;
    }

    public String getUserSuffix() {
        return suffix;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
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
        return id == ((UserProfile) obj).id;
    }
}