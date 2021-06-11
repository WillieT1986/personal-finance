package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserProfileTest {

    UserProfile underTest;

    @BeforeEach
    public void setUp() {
        underTest = new UserProfile();
    }

    @Test
    public void shouldInstantiateUserProfile() {
        assertNotNull(underTest);
    }

}