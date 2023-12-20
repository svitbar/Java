package org.example;

import org.example.task1.Account;
import org.example.task1.Bank;
import org.example.task1.Transfer;
import org.example.task2.CircularBuffer;
import org.example.task2.Consumer;
import org.example.task2.Producer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // performTransfer();
        performTask2();
    }

    public static void performTransfer() {
        int threads = 1000;
        int accounts = 100;

        Bank bank = new Bank(accounts);

        int startBalance = bank.getBankBalance();
        System.out.println("Bank balance at the beginning: " + startBalance);
        Thread[] t = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            Account randomAccount = bank.getAccounts()[(int) (Math.random() * bank.getAccounts().length)];
            t[i] = new Thread(new Transfer(bank, randomAccount, randomAccount.getBalance() * 2));
            t[i].start();
        }

        try {
            for (Thread tr: t) {
                tr.join();
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        int endBalance = bank.getBankBalance();
        System.out.println("Bank balance at the end: " + endBalance);
    }

    public static void performTask2() throws InterruptedException {
        int threadsP = 5;
        int threadsC = 2;

        Thread[] tP = new Thread[threadsP];
        Thread[] tC = new Thread[threadsC];

        CircularBuffer bufferProducer = new CircularBuffer();
        CircularBuffer bufferConsumer = new CircularBuffer();

        for (int i = 0; i < threadsP; i++) {
            tP[i] = new Thread(new Producer(bufferProducer, i + 1));
            tP[i].setDaemon(true);
            tP[i].start();
        }

        for (int i = 0; i < threadsC; i++) {
            tC[i] = new Thread(new Consumer(bufferProducer, bufferConsumer, i + 1));
            tC[i].setDaemon(true);
            tC[i].start();
        }

        for (int i = 1; i <= 100; i++) {
            System.out.println("Iteration " + i);
            String removedMess = bufferConsumer.removeMessage();
            System.out.println(removedMess);
        }
    }
}