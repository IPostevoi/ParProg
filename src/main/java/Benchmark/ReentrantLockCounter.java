package Benchmark;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements Counter {

    private int counter;
    private ReentrantLock lock = new ReentrantLock(true);


    public ReentrantLockCounter(int counter) {
        this.counter = counter;
    }



    @Override
    public int get() {
        return counter;
    }

    @Override
    public int getAndIncrement() {
        lock.lock();
        int temp = counter;
        try {
            counter++;
        } finally {
            lock.unlock();
        }
        return temp;
    }
}
