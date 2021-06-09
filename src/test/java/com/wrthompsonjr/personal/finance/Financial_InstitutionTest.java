package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Financial_InstitutionTest {

    private static final String NAME = "USAA";
    private static final String FINANCIAL_INSTITUTION_TYPE = "Bank";

    Financial_Institution underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Financial_Institution(NAME, FINANCIAL_INSTITUTION_TYPE);
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

    @Test
    public void shouldReturnAFinancialInstitutionType() {
        String check = underTest.getFinancialInstitutionType();
        assertEquals(FINANCIAL_INSTITUTION_TYPE, check);
    }
}