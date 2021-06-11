package com.wrthompsonjr.personal.finance;

public class UserProfile {

    public String firstName;
    public String middleName;
    public String lastName;
    public String suffix;
    public String userEmail;

    public UserProfile(String firstName, String middleName, String lastName, String suffix, String userEmail) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.userEmail = userEmail;
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
}