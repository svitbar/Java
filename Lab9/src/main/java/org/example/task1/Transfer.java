package org.example.task1;

public class Transfer implements Runnable {
    private final Bank bank;
    private final Account account;
    private final int maxSum;

    public Transfer(Bank bank, Account account, int maxSum) {
        this.bank = bank;
        this.account = account;
        this.maxSum = maxSum;
    }

    @Override
    public void run() {
        try {
            double sum = (Math.random() * maxSum) / 2;
            Account toAccount = bank.getAccounts()[(int) (Math.random() * bank.getAccounts().length)];
            bank.transfer(account, toAccount, (int) sum);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
