package com.vijeth.threads;

import java.util.UUID;

class Buffer{
    private String data;
    private Boolean isEmpty;


    public Buffer(){
        this.isEmpty = true;
    }

    public synchronized void produce(String newData) throws InterruptedException {
        while(!this.isEmpty){
            this.wait();
        }
        this.data = newData;
        System.out.println("Produced new data: "+this.data);
        this.isEmpty = false;
        this.notify();
    }

    public synchronized void consumer() throws InterruptedException {
        while(this.isEmpty){
            this.wait();
        }
        System.out.println("Consumed data: "+this.data);
        this.data = null;
        this.isEmpty = true;
        this.notify();
    }

}

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producer = new Thread(()->{
           while(true){
               try {
                   buffer.produce(UUID.randomUUID().toString());
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });


        Thread consumer = new Thread(()->{
            while(true){
                try {
                    buffer.consumer();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
