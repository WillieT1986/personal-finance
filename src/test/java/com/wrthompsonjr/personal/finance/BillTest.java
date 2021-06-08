package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BillTest {

    Bill underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Bill();
    }

    @Test
    public void shouldInstantiateABill() {
        assertNotNull(underTest);
    }

}