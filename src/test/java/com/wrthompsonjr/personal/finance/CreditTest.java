package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreditTest {

    private static final String CREDIT_NAME = "United Explorers Credit Card";
    private static final String CREDIT_TYPE = "Credit Card";

    Credit underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Credit(CREDIT_NAME, CREDIT_TYPE);
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

    @Test
    public void shouldReturnCreditType() {
        String check = underTest.getCreditType();
        assertEquals(CREDIT_TYPE, check);
    }
}