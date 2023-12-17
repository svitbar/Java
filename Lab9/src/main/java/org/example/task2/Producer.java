package org.example.task2;

public class Producer implements Runnable {
    private final CircularBuffer buffer;
    private final int index;
    private static int messageCount = 0;

    public Producer(CircularBuffer buffer, int index) {
        this.buffer = buffer;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                String message = "Thread #" + index + " generated message " + ++messageCount;
                buffer.addMessage(message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
