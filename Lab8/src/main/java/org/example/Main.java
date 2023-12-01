package org.example;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        startProgram(8);
    }

    public static void startProgram(int threads) {
        long startTime = System.nanoTime();
        int iterations = 1_000_000_000;
        int inside = 0;

        MyRunnable r = new MyRunnable(iterations / threads);
        Thread[] t = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            t[i] = new Thread(r);
            t[i].start();
        }

        try {
            for (Thread tr: t) {
                tr.join();
                inside += r.getInside();
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        double pi = 4.0 * inside / iterations;

        long endTime = System.nanoTime();

        double duration = (double) (endTime - startTime) / 1_000_000;

        DecimalFormat df = new DecimalFormat("0.00");
        String formattedDuration = df.format(duration);

        System.out.println("PI is " + pi);
        System.out.println("THREADS " + threads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("Time " + formattedDuration + " ms");
    }
}