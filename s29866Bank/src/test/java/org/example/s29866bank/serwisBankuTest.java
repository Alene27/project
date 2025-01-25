package org.example.s29866bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class serwisBankuTest {
    @Mock
    private bankStorage bankStorage;
    private serwisBanku serwis;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        serwis = new serwisBanku(bankStorage);
    }

    @Test
    void shouldDeclinePrzelewWhenInsufficientFunds() {
        status result = serwis.wykonajPrzelew(1, 100.0, 50.0);
        assertEquals(status.ACCEPTED, result);
    }

    @Test
    void shouldAcceptPrzelewWhenSufficientFunds() {
        status result = serwis.wykonajPrzelew(1, 50.0, 100.0);
        assertEquals(status.DECLINED, result);
    }

    @Test
    void shouldShowCorrectFormat() {
        String result = serwis.show(1, 100.0);
        assertEquals("1 100.0", result);
    }

    @Test
    void shouldAlwaysAcceptCashOut() {
        status result = serwis.cashOut(1, 100.0, 50.0);
        assertEquals(status.ACCEPTED, result);
    }
}

