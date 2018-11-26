package Benchmark;

public class MonitorCounter implements Counter {

    private int counter;
    private static final Object monitor = new Object();


    public MonitorCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int get() {
        return counter;
    }

    @Override
    public int getAndIncrement() {
        int temp;
        synchronized (monitor) {
            temp = counter;
            counter++;
        }
        return temp;
    }
}
