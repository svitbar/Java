package org.example.task2;

public class Consumer implements Runnable {
    private final CircularBuffer bufferProducer;
    private final CircularBuffer bufferConsumer;
    private final int index;

    public Consumer(CircularBuffer bufferProducer, CircularBuffer bufferConsumer, int index) {
        this.bufferProducer = bufferProducer;
        this.bufferConsumer = bufferConsumer;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String producerMess = bufferProducer.removeMessage();
                String message = "Thread #" + index + " read message: " + producerMess;
                bufferConsumer.addMessage(message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
