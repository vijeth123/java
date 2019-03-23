package com.vijeth.geeksforgeeks.algorithms;


public class Fibonacci {

    public static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int fib2(int n){
        int[]result = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        for(int i=2;i<=n;i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println("Fib(6) is: "+ fib(7));
        System.out.println("Fib2(6) is: "+ fib2(7));
    }

}
