package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserProfileTest {

    private static final String FIRST_NAME = "First";
    private static final String MIDDLE_NAME = "Middle";
    private static final String LAST_NAME = "Last";
    private static final String SUFFIX = "II";

    UserProfile underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserProfile(FIRST_NAME, MIDDLE_NAME, LAST_NAME, SUFFIX);
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
}