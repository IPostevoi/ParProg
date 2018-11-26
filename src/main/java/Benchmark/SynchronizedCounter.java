package Benchmark;

public class SynchronizedCounter implements Counter {

    private int counter;

    public SynchronizedCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public synchronized int get() {
        return counter;
    }

    @Override
    public synchronized int getAndIncrement() {
        int temp = counter;
        counter++;
        return temp;
    }
}
