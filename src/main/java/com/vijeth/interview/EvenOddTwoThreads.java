package com.vijeth.interview;

class Flag {
    private volatile boolean isOdd = true;
    volatile int counter = 0;

    public void setOdd(boolean odd) {
        isOdd = odd;
    }

    public boolean isOdd() {
        return isOdd;
    }
}

class OddPrinter implements Runnable {
    private Flag flag;

    public OddPrinter(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag.counter < 100) {
            while (!flag.isOdd()) {
                //Just wait
            }
            System.out.println(flag.counter++);
            flag.setOdd(false);
        }

    }
}

class EvenPrinter implements Runnable {
    private Flag flag;

    public EvenPrinter(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag.counter < 100) {
            while (flag.isOdd()) {
                //Just wait
            }
            System.out.println(flag.counter++);
            flag.setOdd(true);
        }
    }
}


public class EvenOddTwoThreads {
    public static void main(String[] args) throws InterruptedException {
        Flag flag = new Flag();
        Thread oddThread = new Thread(new OddPrinter(flag));
        Thread evenThread = new Thread(new EvenPrinter(flag));

        oddThread.start();
        evenThread.start();
    }
}
