package com.vijeth.threads;

import java.util.UUID;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for(int i=0;i<5;i++) {
                System.out.println(UUID.randomUUID());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println("We are done!");
    }
}
