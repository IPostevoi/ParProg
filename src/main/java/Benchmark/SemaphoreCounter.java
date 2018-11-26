package Benchmark;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter implements Counter {

    private Semaphore semaphore = new Semaphore(1);
    private int counter;

    public SemaphoreCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int get() {
        return counter;
    }

    @Override
    public int getAndIncrement() {
        int temp = 0;
        try {
            semaphore.acquire();
            temp = counter;
            ++counter;
        } catch (InterruptedException e) {}
        finally {
            semaphore.release();
        }
        return temp;
    }
}
