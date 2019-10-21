package program;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
        if (balance<0) {
            balance = 0;
        }
    }

    public void deposit(int amount) {
        balance = balance + amount;
        if (balance<0) {
            balance = 0;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
