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

    UserProfile userProfileTest;
    Bill billTest;
    Income income;

    @BeforeEach
    public void setUp() {
        billTest = new Bill(userProfileTest, NAME, COST, DUE_DATE, FREQUENCY, SUBSCRIPTION);
        userProfileTest = new UserProfile("FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", "SUFFIX", "USER_EMAIL", "USER_PHONE_NUMBER", income);
    }

    @Test
    public void shouldInstantiateABill() {
        assertNotNull(billTest);
    }

    @Test
    public void shouldConstructABillAndReturnABillName() {
        String check = billTest.getName();
        assertEquals(NAME, check);
    }

    @Test
    public void shouldReturnCostOfBill() {
        Double check = billTest.getCost();
        assertEquals(COST, check);
    }

    @Test
    public void shouldReturnDueDateOfBill() {
        String check = billTest.getDueDate();
        assertEquals("08", check);
    }

    @Test
    public void shouldReturnTheFrequencyOfABill() {
        String check = billTest.getFrequency();
        assertEquals("Monthly", check);
    }

    @Test
    public void shouldReturnAnIndicatorForSubscription() {
        String check = billTest.getSubscriptionIndicator();
        assertEquals(SUBSCRIPTION, check);
    }
}