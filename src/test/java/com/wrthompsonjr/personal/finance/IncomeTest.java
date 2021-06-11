package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeTest {

    private static final String SOURCE = "Work";
    private static final Double AMOUNT = 2500.00;
    private static final String DATE_RECEIVED = "07/01/2021";
    private static final String INCOME_FREQUENCY = "Monthly";

    Income underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Income(SOURCE, AMOUNT, DATE_RECEIVED, INCOME_FREQUENCY);
    }

    @Test
    public void shouldReturnTheSource() {
        String check = underTest.getSourceOfIncome();
        assertEquals(SOURCE, check);
    }

    @Test
    public void shouldReturnTheAmountEarned() {
        Double check = underTest.getIncomeAmount();
        assertEquals(AMOUNT, check);
    }

    @Test
    public void shouldReturnDateReceived() {
        String check = underTest.getDateReceived();
        assertEquals(DATE_RECEIVED, check);
    }

    @Test
    public void shouldReturnIncomeFrequency() {
        String check = underTest.getIncomeFrequency();
        assertEquals(INCOME_FREQUENCY, check);
    }
}