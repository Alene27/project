package org.example.s29866bank;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class bankStorage {
    private static List<Konto> listaKont;

    public bankStorage() {
        bankStorage.listaKont = new ArrayList<>();
    }

    public static void addKonto(Konto konto) {
        listaKont.add(konto);
    }

    public List<Konto> getKontoList() {
        return listaKont;
    }
}
