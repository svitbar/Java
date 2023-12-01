package org.example;

public class MyRunnable implements Runnable{
    public int iterations;
    private int inside;

    public MyRunnable(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        inside = MonteCarloPi.getPi(iterations);
    }

    public int getInside() {
        return inside;
    }
}
