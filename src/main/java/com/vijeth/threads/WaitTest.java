package com.vijeth.threads;

class SumThread extends Thread{
    int sum = 0;
    @Override
    public void run() {
        synchronized (this){
            for(int i=1;i<=100;i++){
                sum += i;
            }
            this.notify();
        }

    }
}


public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        SumThread sumThread = new SumThread();
        sumThread.start();

        synchronized (sumThread){
            System.out.println("Sum before wait() is: "+ sumThread.sum);
            sumThread.wait();
            System.out.println("Sum after wait() is: "+ sumThread.sum);
        }
    }
}
