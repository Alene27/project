package org.example.s29866bank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")

class fullIntTest {

    @Autowired
    private bankStorage bankStorage;

    @Autowired
    private serwisBanku serwisBanku;

    @Test
    void shouldPerformFullBankOperation() {
        Konto konto = new Konto(1, 1000.0);
        bankStorage.addKonto(konto);

        status przelewStatus = serwisBanku.wykonajPrzelew(1, 500.0, 800.0);
        String pokazKonto = serwisBanku.show(1, 500.0);
        status wyplataStatus = serwisBanku.cashOut(1, 200.0, 500.0);

        assertEquals(status.DECLINED, przelewStatus);
        assertEquals("1 500.0", pokazKonto);
        assertEquals(status.ACCEPTED, wyplataStatus);
        assertTrue(bankStorage.getKontoList().contains(konto));
    }

    @Test
    void shouldHandleMultipleAccounts() {
        Konto konto1 = new Konto(1, 1000.0);
        Konto konto2 = new Konto(2, 2000.0);
        bankStorage.addKonto(konto1);
        bankStorage.addKonto(konto2);

        status przelew1 = serwisBanku.wykonajPrzelew(1, 300.0, 500.0);
        status przelew2 = serwisBanku.wykonajPrzelew(2, 1500.0, 1000.0);

        assertEquals(status.ACCEPTED, przelew1);
        assertEquals(status.DECLINED, przelew2);
        assertEquals(2, bankStorage.getKontoList().size());
    }

    @Test
    void shouldHandleTransactionSequence() {
        Konto konto = new Konto(1, 1000.0);
        bankStorage.addKonto(konto);

        status przelew = serwisBanku.wykonajPrzelew(1, 500.0, 800.0);
        status wyplata = serwisBanku.cashOut(1, 200.0, 500.0);
        String stan = serwisBanku.show(1, 300.0);

        assertEquals(status.DECLINED, przelew);
        assertEquals(status.ACCEPTED, wyplata);
        assertEquals("1 300.0", stan);
    }
}
