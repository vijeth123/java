package com.vijeth.threads.synchronizers;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class MyConnection {
    private static final MyConnection INSTANCE = new MyConnection();
    private int noOfConnections = 0;
    private Semaphore semaphore = new Semaphore(10);

    private MyConnection() {
    }

    public static MyConnection getInstance() {
        return INSTANCE;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            ++noOfConnections;
            System.out.println("Current number of connections: " + noOfConnections);
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            --noOfConnections;
            System.out.println("Current number of connections: " + noOfConnections);
        }
        semaphore.release();
    }

}


public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < 100; i++) {
                executorService.submit(() -> {
                    MyConnection.getInstance().connect();
                });
            }
        } finally {
            executorService.shutdown();
        }
    }
}
