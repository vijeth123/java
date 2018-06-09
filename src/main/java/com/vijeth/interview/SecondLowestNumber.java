package com.vijeth.interview;

public class SecondLowestNumber {

    public static int getSecondLowestNumber(int[] arr){
        int min = Integer.MAX_VALUE;
        int oldMin = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] < min){
                oldMin = min;
                min = arr[i];
            }else if(arr[i] > min && arr[i] < oldMin){
                oldMin = arr[i];
            }
        }
        System.out.println("\nFirst lowest number is: "+min);
        return oldMin;
    }

    public static void main(String[] args) {
        int[] arr = {20,30,40,10,50};
        for (int a: arr) {
            System.out.print(a+"\t");
        }

        System.out.println("Second lowest number is: "+getSecondLowestNumber(arr));
    }

}
