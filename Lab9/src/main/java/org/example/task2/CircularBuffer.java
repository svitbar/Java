package org.example.task2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBuffer {
    private final LinkedList<String> buffer;
    private int main = 0;
    private int end = 0;
    private final Lock bl;
    private final Condition con;

    public CircularBuffer() {
        this.buffer = new LinkedList<>();
        bl = new ReentrantLock();
        con = bl.newCondition();
    }

    public void addMessage(String message) throws InterruptedException {
        bl.lock();

        try {
            while (!buffer.isEmpty() && main == end) {
                con.await();
            }

            buffer.add(message);
            end++;

            con.signal();
        } finally {
            bl.unlock();
        }
    }

    public String removeMessage() throws InterruptedException {
        bl.lock();

        try {
            while (buffer.isEmpty()) {
                con.await();
            }

            String removedMess = buffer.removeFirst();
            main++;

            con.signal();

            return removedMess;
        } finally {
            bl.unlock();
        }
    }
}
