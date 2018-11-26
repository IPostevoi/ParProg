package Benchmark;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

    private AtomicInteger counter;

    public AtomicCounter(int start) {
        this.counter = new AtomicInteger(0);
    }

    @Override
    public int get() {
        return counter.get();
    }

    @Override
    public int getAndIncrement() {
        return counter.getAndIncrement();
    }
}
