package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BillTest {

    private static final String NAME = "AEP Electric";
    private static final Double COST = 50.05;

    Bill underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Bill(NAME, COST);
    }

    @Test
    public void shouldInstantiateABill() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldConstructABillAndRetrunABillName() {
        String check = underTest.getName();
        assertEquals(NAME, check);
    }

    @Test
    public void shouldReturnCostOfBill() {
        Double check = underTest.getCost();
        assertEquals(COST, check);
    }

}