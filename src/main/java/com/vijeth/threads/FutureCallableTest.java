package com.vijeth.threads;

import java.util.concurrent.*;

class MyCallable implements Callable<Integer>{

    private int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= num ; i++) {
            sum+=i;
        }
        return sum;
    }
}

public class FutureCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable(10);
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(myCallable);
        System.out.println("Sum is: "+future.get());
        executorService.shutdown();
    }
}
