package org.example.s29866bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class S29866BankApplication {
    private final bankStorage bankStorage;
    private final serwisBanku serwisBanku;

    public S29866BankApplication(bankStorage bankStorage, serwisBanku serwisBanku) {
        this.bankStorage = bankStorage;
        this.serwisBanku = serwisBanku;
    }

    public static void main(String[] args) {
        SpringApplication.run(S29866BankApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void Start() {
        Konto konto1 = new Konto(1, 123);
        Konto konto2 = new Konto(2, 328);
        Konto konto3 = new Konto(3, 2137);
        Konto konto4 = new Konto(4, 235);

        bankStorage.addKonto(konto1);
        bankStorage.addKonto(konto2);
        bankStorage.addKonto(konto3);

        bankStorage.getKontoList().clear();
        bankStorage.getKontoList().add(konto1);

        System.out.println(konto1.getSaldoKonta());
        System.out.println(serwisBanku.wykonajPrzelew(1, 23, 7483));
        System.out.println(serwisBanku.show(1, 23));

    }
}