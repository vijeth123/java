package com.vijeth.threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Reader implements Runnable{
    private BlockingQueue<Integer> queue;

    public Reader(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(Thread.currentThread().getName() + " read: " + queue.take()+"\n");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class Writer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Writer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true){
            Integer integer = random.nextInt();
            System.out.println(Thread.currentThread().getName()+" WRITING to the queue with value: "+ integer+"\n");
            try {
                queue.put(integer);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Reader reader = new Reader(queue);
        Writer writer = new Writer(queue);

        Thread reader1 = new Thread(reader, "Reader-1");
        Thread reader2 = new Thread(reader, "Reader-2");
        Thread reader3 = new Thread(reader, "Reader-3");
        Thread reader4 = new Thread(reader, "Reader-4");
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();

        Thread writer1 = new Thread(writer, "Writer-1");
        Thread writer2 = new Thread(writer, "Writer-2");
        Thread writer3 = new Thread(writer, "Writer-3");
        writer1.start();
        writer2.start();
        writer3.start();
    }
}
