package com.vijeth.threads.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class DevTeam extends Thread{

    private CountDownLatch countDownLatch;

    public DevTeam(CountDownLatch countDownLatch, String name){
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Task assigned to DevTeam: "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task finished by DevTeam: "+Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}


public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        DevTeam devTeamA = new DevTeam(countDownLatch, "devTeamA");
        DevTeam devTeamB = new DevTeam(countDownLatch, "devTeamB");
        devTeamA.start();
        devTeamB.start();

        countDownLatch.await();

        Thread qaTeam = new Thread(() -> {
            System.out.println("Task assigned to qaTeam: "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task finished by qaTeam: "+Thread.currentThread().getName());
        });
        qaTeam.start();
    }
}
