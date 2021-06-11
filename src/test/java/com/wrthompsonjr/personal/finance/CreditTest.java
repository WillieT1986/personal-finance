package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreditTest {

    private static final String CREDIT_NAME = "United Explorers Credit Card";

    Credit underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Credit(CREDIT_NAME);
    }

    @Test
    public void shouldInstantiateCredit() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldReturnNameOfCreditCard() {
        String check = underTest.getCreditName();
        assertEquals(CREDIT_NAME, check);
    }
}