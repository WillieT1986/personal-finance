package com.wrthompsonjr.personal.finance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreditTest {

    Credit underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Credit();
    }

    @Test
    public void shouldInstantiateCredit() {
        assertNotNull(underTest);
    }

}