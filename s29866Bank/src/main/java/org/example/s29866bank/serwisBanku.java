package org.example.s29866bank;
import org.springframework.stereotype.Service;

@Service
public class serwisBanku {
    private bankStorage bankStorage;

    public serwisBanku(bankStorage bankStorage) {
        this.bankStorage = bankStorage;
    };

    public status wykonajPrzelew(int id, double amount, double balance) {
        double result = amount - balance;
        if (result < 0) {
            return status.DECLINED;
        } else {
            return status.ACCEPTED;
        }
    };

    public String show(int id, double amount) {
      return id + " " + amount;
    }

    public status cashOut(int id, double amount, double balance) {
        double result = amount + balance;
        return status.ACCEPTED;
    }
}
