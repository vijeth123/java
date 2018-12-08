package com.vijeth.interview;

import java.util.concurrent.TimeUnit;

class Counter{
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}

class EventThread extends Thread{
    private Counter counter;

    public EventThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while(true){
            if(counter.getCount() % 2 == 0){
                System.out.println(counter.getCount()+" printed by: "+Thread.currentThread().getName());
                counter.setCount(counter.getCount() + 1);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddThread extends Thread{
    private Counter counter;

    public OddThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while(true){
            if(counter.getCount() % 2 != 0){
                System.out.println(counter.getCount()+" printed by: "+Thread.currentThread().getName());
                counter.setCount(counter.getCount() + 1);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



public class OddEven {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.setCount(0);

        OddThread oddThread = new OddThread(counter);
        oddThread.setName("Odd-Thread");

        EventThread eventThread = new EventThread(counter);
        eventThread.setName("Even-Thread");

        oddThread.start();
        eventThread.start();
    }
}
