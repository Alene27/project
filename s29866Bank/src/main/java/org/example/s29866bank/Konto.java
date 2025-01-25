package org.example.s29866bank;

public class Konto {
    private int id;
    private double saldoKonta;

    public Konto(int id, double saldoKonta) {
        this.id = id;
        this.saldoKonta = saldoKonta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldoKonta() {
        return saldoKonta;
    }

    public void setSaldoKonta(double saldoKonta) {
        this.saldoKonta = saldoKonta;
    }
}
