package com.vijeth.threads;

import java.util.UUID;

public class DaemonThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(true) {
                System.out.println(UUID.randomUUID());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
        System.out.println("We are done!");
    }
}
