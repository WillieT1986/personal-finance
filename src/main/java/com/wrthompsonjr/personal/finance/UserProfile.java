package com.wrthompsonjr.personal.finance;

public class UserProfile {

    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;

    public UserProfile(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
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
}