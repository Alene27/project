package org.example.s29866bank;

// operacjeBankoweTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class operacjeBankoweTest {
    @Test
    void shouldCreateOperacjeBankoweWithCorrectValues() {
        Konto konto = new Konto(1, 100.0);
        operacjeBankowe operacja = new operacjeBankowe(konto, 50.0, status.ACCEPTED);

        assertEquals(konto, operacja.getKonto());
        assertEquals(50.0, operacja.getPrzelewy());
        assertEquals(status.ACCEPTED, operacja.getStatus());
    }

    @Test
    void shouldUpdateOperacjeBankoweValues() {
        Konto konto1 = new Konto(1, 100.0);
        Konto konto2 = new Konto(2, 200.0);
        operacjeBankowe operacja = new operacjeBankowe(konto1, 50.0, status.ACCEPTED);

        operacja.setKonto(konto2);
        operacja.setPrzelewy(75.0);
        operacja.setStatus(status.DECLINED);

        assertEquals(konto2, operacja.getKonto());
        assertEquals(75.0, operacja.getPrzelewy());
        assertEquals(status.DECLINED, operacja.getStatus());
    }
}
