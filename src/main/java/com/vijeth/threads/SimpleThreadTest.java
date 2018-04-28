package com.vijeth.threads;

public class SimpleThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
           for(int i=1; i<=10; i++){
               System.out.print(i+" "+Thread.currentThread().getName()+"\t");
           }
        }, "MyThread");
        t.start();
        System.out.println("Done: "+Thread.currentThread());
    }
}