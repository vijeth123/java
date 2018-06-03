package com.vijeth.threads.synchronizers;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class PassengerThread extends Thread{
    private CyclicBarrier cyclicBarrier;
    private int delay;

    public PassengerThread(String name, CyclicBarrier cyclicBarrier, int delay){
        super(name);
        this.cyclicBarrier = cyclicBarrier;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(delay);
            System.out.println(Thread.currentThread().getName()+" arrived");
            if(cyclicBarrier.await() == 0){
                System.out.println("Four passengers have arrived..!! Cab can start now!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        PassengerThread passengerThread1 = new PassengerThread("Vijeth", cyclicBarrier, 4);
        PassengerThread passengerThread2 = new PassengerThread("Bharath", cyclicBarrier, 5);
        PassengerThread passengerThread3 = new PassengerThread("Mahesh", cyclicBarrier, 3);
        PassengerThread passengerThread4 = new PassengerThread("Prasanna", cyclicBarrier, 2);
        passengerThread1.start();
        passengerThread2.start();
        passengerThread3.start();
        passengerThread4.start();

        PassengerThread passengerThread5 = new PassengerThread("Sri", cyclicBarrier, 7);
        PassengerThread passengerThread6 = new PassengerThread("Jags", cyclicBarrier, 9);
        PassengerThread passengerThread7 = new PassengerThread("Viru", cyclicBarrier, 6);
        PassengerThread passengerThread8 = new PassengerThread("Sanketh", cyclicBarrier, 8);
        passengerThread5.start();
        passengerThread6.start();
        passengerThread7.start();
        passengerThread8.start();
    }
}
