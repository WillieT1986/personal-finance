package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BillTest {

    private static final String NAME = "AEP Electric";
    private static final Double COST = 50.05;
    private static final String DUE_DATE = "08";
    private static final String FREQUENCY = "Monthly";
    private static final String SUBSCRIPTION = "No";

    Bill underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Bill(NAME, COST, DUE_DATE, FREQUENCY, SUBSCRIPTION);
    }

    @Test
    public void shouldInstantiateABill() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldConstructABillAndReturnABillName() {
        String check = underTest.getName();
        assertEquals(NAME, check);
    }

    @Test
    public void shouldReturnCostOfBill() {
        Double check = underTest.getCost();
        assertEquals(COST, check);
    }

    @Test
    public void shouldReturnDueDateOfBill() {
        String check = underTest.getDueDate();
        assertEquals("08", check);
    }

    @Test
    public void shouldReturnTheFrequencyOfABill() {
        String check = underTest.getFrequency();
        assertEquals("Monthly", check);
    }

    @Test
    public void shouldReturnAnIndicatorForSubscription() {
        String check = underTest.getSubscriptionIndicator();
        assertEquals(SUBSCRIPTION, check);
    }
}