package Benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


public class SynchronizedCounterTest {

    @State(Scope.Benchmark)
    public static class MyState {
        Counter counter;
        @Setup
        public void setup() {
            counter = new SynchronizedCounter(0);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Threads(1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void thread1(MyState myState) throws Exception {
//           System.out.println(Thread.currentThread().getId() + ": " + myState.counter.getAndIncrement());
           myState.counter.getAndIncrement();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Threads(2)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void thread2(MyState myState) throws Exception {
            myState.counter.getAndIncrement();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Threads(4)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void thread4(MyState myState) throws Exception {
            myState.counter.getAndIncrement();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Threads(8)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void thread8(MyState myState) throws Exception {
            myState.counter.getAndIncrement();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Threads(16)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void thread16(MyState myState) throws Exception {
            myState.counter.getAndIncrement();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 3)
    @Measurement(iterations = 5)
    @Threads(32)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void thread32(MyState myState) throws Exception {
            myState.counter.getAndIncrement();
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }


}
