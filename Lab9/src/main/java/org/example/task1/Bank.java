package org.example.task1;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final Account[] accounts;
    private final Lock bl;

    public Bank(int n) {
        this.accounts = new Account[n];

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            accounts[i] = new Account(i + 1, Math.abs(random.nextInt(0, 1000)));
            // System.out.println("Account " + (i + 1) + " balance: " + accounts[i].getBalance());
        }

        bl = new ReentrantLock();
    }

    public void transfer(Account from, Account to, int amount) throws InterruptedException {
        bl.lock();
        try {
            System.out.print(Thread.currentThread());
            System.out.println("Transfer " + amount + " from " + from + " to " + to + "...");
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Success");
            } else {
                throw new RuntimeException("Not enough money for this transaction.");
            }
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Bank balance: " + getBankBalance());
            bl.unlock();
        }
    }

    public int getBankBalance() {
        bl.lock();
        int balance = 0;

        try {
            for (Account account: accounts) {
                balance += account.getBalance();
            }
        } finally {
            bl.unlock();
        }

        return balance;
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
