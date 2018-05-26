package com.vijeth.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " acquired lock!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class SynchronizedTest {
    public static void main(String[] args) {
        Runnable runnable = new MyThread();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<5;i++){
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
