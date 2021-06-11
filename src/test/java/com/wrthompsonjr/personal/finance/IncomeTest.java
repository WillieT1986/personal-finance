package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeTest {
    private static final String SOURCE = "Work";
    Income underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Income(SOURCE);
    }

    @Test
    public void shouldReturnTheSource() {
        String check = underTest.getSourceOfIncome();
        assertEquals(SOURCE, check);

    }
}