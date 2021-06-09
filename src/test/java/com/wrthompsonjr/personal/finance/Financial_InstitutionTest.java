package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Financial_InstitutionTest {

    private static final String NAME = "USAA";

    Financial_Institution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Financial_Institution(NAME);
    }

    @Test
    public void shouldInstantiateAFinancialInstitution() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldConstructAFinancialInstitutionAndReturnAName() {
        String check = underTest.getName();
        assertEquals(NAME, check);
    }

}