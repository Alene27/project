package org.example.s29866bank;

// KontoTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KontoTest {
    @Test
    void shouldCreateKontoWithCorrectValues() {
        Konto konto = new Konto(1, 100.0);

        assertEquals(1, konto.getId());
        assertEquals(100.0, konto.getSaldoKonta());
    }

    @Test
    void shouldUpdateKontoValues() {
        Konto konto = new Konto(1, 100.0);

        konto.setId(2);
        konto.setSaldoKonta(200.0);

        assertEquals(2, konto.getId());
        assertEquals(200.0, konto.getSaldoKonta());
    }
}

