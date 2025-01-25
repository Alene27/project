package org.example.s29866bank;

public class operacjeBankowe {
    private Konto konto;
    private double przelew;
    private status status;

    public operacjeBankowe(Konto konto, double przelewy, status status) {
        this.konto = konto;
        this.przelew = przelewy;
        this.status = status;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public double getPrzelewy() {
        return przelew;
    }

    public void setPrzelewy(double przelewy) {
        this.przelew = przelewy;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }
}
