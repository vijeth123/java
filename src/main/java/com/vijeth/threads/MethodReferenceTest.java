package com.vijeth.threads;

public class MethodReferenceTest {
    public static void main(String[] args) {
        Thread thread = new Thread(MethodReferenceTest::sayHi);
        thread.start();
    }

    private static void sayHi(){
        for(int i=1;i<=10;i++){
            System.out.println(i+") Hi Vijeth!");
        }
    }
}
