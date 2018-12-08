package com.vijeth.interview;

import java.util.UUID;

public class MyStringReverse {

    public static String reverse(String str){
        char[] arr = str.toCharArray();
        int n = arr.length;

        for(int i = 0, j = n-1; i < n/2; i++, j--){
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "Vijeth";
        System.out.println("Reverse of ["+str+"] is: [" +reverse(str)+"]");
    }

}
