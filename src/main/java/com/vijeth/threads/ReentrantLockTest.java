package com.vijeth.threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class MyCounter{

    private int count = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void incrementCount() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName()+":\t"+(++count));
        reentrantLock.unlock();
    }

    public int getCount(){
        return count;
    }
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();

ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable1 = () -> {
            for (int i = 0; i < 30000; i++) {
                myCounter.incrementCount();
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 50000; i++) {
                myCounter.incrementCount();
            }
        };
        executorService.execute(runnable1);
        executorService.execute(runnable2);

        System.out.println(myCounter.getCount());

        executorService.shutdown();
    }
}
