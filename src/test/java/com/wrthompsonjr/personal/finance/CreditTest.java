package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreditTest {

    private static final String CREDIT_NAME = "United Explorers Credit Card";
    private static final String CREDIT_TYPE = "Credit Card";
    private static final Double CREDIT_AMOUNT = 500.00;
    private static final String CREDIT_ISSUER = "Chase Bank";

    Credit underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Credit(CREDIT_NAME, CREDIT_TYPE, CREDIT_AMOUNT, CREDIT_ISSUER);
    }

    @Test
    public void shouldInstantiateCredit() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldReturnNameOfCredit() {
        String check = underTest.getCreditName();
        assertEquals(CREDIT_NAME, check);
    }

    @Test
    public void shouldReturnCreditType() {
        String check = underTest.getCreditType();
        assertEquals(CREDIT_TYPE, check);
    }

    @Test
    public void shouldReturnCreditAmount() {
        Double check = underTest.getCreditAmount();
        assertEquals(CREDIT_AMOUNT, check);
    }

    @Test
    public void shouldReturnCreditIssuer() {
        String check = underTest.getCreditIssuer();
        assertEquals(CREDIT_ISSUER, check);
    }
}