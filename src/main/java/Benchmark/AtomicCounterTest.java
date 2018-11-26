package Benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


public class AtomicCounterTest {

    @State(Scope.Benchmark)
    public static class MyState {
        AtomicCounter counter;
        @Setup
        public void setup() {
            counter = new AtomicCounter(0);
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
////        Runnable runnable = () -> {
////            int cnt;
////            while (myState.counter.get() < 100) {
////                cnt = myState.counter.getAndIncrement();
////                System.out.println(Thread.currentThread().getName() + ": " + cnt);
////            }
////        };
////
////        Thread thread1 = new Thread(runnable);
////        Thread thread2 = new Thread(runnable);
////        Thread thread3 = new Thread(runnable);
////        Thread thread4 = new Thread(runnable);
////        Thread thread5 = new Thread(runnable);
////        Thread thread6 = new Thread(runnable);
////        Thread thread7 = new Thread(runnable);
////        Thread thread8 = new Thread(runnable);
////        thread1.start();
////        thread2.start();
//////        thread3.start();
//////        thread4.start();
//////        thread5.start();
//////        thread6.start();
//////        thread7.start();
//////        thread8.start();
//
//        for (int i = 0; i < myState.n; i++) {
//            myState.threads.add(new ThreadTest(myState.counter, 10));
//        }
//
//        for (int i = 0; i < myState.n; i++) {
//            myState.threads.get(i).start();
//            myState.threads.get(i).join();
//        }
//            System.out.println(Thread.currentThread().getId() + ": " + myState.counter.get());
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
