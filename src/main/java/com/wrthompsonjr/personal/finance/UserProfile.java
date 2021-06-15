package com.wrthompsonjr.personal.finance;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.engine.internal.Cascade;

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
    private Financial_Institution financialInstitution;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Income income;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Credit credit;

    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public String userEmail;
    public String userPhoneNumber;

    public UserProfile() {
    }

    public UserProfile(String firstName, String middleName, String lastName, String suffix, String userEmail, String userPhoneNumber,
                       Bill bill, Financial_Institution financialInstitution, Income income, Credit credit) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.bill = bill;
        this.financialInstitution = financialInstitution;
        this.income = income;
        this.credit = credit;
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

    public Long getId() {
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
        return id == ((UserProfile) obj).id;
    }
}