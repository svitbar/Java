package org.example.task1;

public class Account {
    private int id;
    private int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (balance < 0) {
            throw new RuntimeException("Balance cannot be negative.");
        }
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account " + id + " {" + balance + "}";
    }
}
