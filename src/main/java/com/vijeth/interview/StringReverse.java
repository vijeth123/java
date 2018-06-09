package com.vijeth.interview;

public class StringReverse {

    public static String reverse(String str){
        char[]arr = str.toCharArray();
        int n = arr.length;

        for(int i=0, j=n-1; i<n/2; i++,j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "Vijeth";
        System.out.println("Original string: "+str);
        System.out.println("Reverese string: "+reverse(str));
    }


}
