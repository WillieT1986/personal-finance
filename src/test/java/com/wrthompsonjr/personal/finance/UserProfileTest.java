package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserProfileTest {

    private static final String FIRST_NAME = "First";
    private static final String MIDDLE_NAME = "Middle";
    private static final String LAST_NAME = "Last";
    private static final String SUFFIX = "II";
    private static final String USER_EMAIL = "Test@wrthompsonjr.com";
    private static final String USER_PHONE_NUMBER = "000-000-0000";

    UserProfile underTest;
    Bill bill;
    Financial_Institution financial_institution;
    Income income;
    Credit credit;

    @BeforeEach
    public void setUp() {
        underTest = new UserProfile(FIRST_NAME, MIDDLE_NAME, LAST_NAME, SUFFIX, USER_EMAIL, USER_PHONE_NUMBER,
                bill, financial_institution, income, credit);
    }

    @Test
    public void shouldInstantiateUserProfile() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldReturnAUsersFirstNameMiddleNameLastNameAndSuffix() {
        String check_firstName = underTest.getUserFirstName();
        String check_middleName = underTest.getUserMiddleName();
        String check_lastName = underTest.getUserLastName();
        String check_suffix = underTest.getUserSuffix();
        assertEquals(FIRST_NAME, check_firstName);
        assertEquals(MIDDLE_NAME, check_middleName);
        assertEquals(LAST_NAME, check_lastName);
        assertEquals(SUFFIX, check_suffix);
    }

    @Test
    public void shouldReturnUsersEmail() {
        String check = underTest.getUserEmail();
        assertEquals(USER_EMAIL, check);
    }

    @Test
    public void shouldReturnUserPhoneNumber() {
        String check = underTest.getUserPhoneNumber();
        assertEquals(USER_PHONE_NUMBER, check);
    }
}