package com.vijeth.interview;

public class LongestIncreasingSubSequenceCount {
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 15, 40, 50, 35, 25};

        int max = 1;
        int oldMax = 1;

        for (int i = 0, j = 1; i < arr.length && j < arr.length - 1; i++, j++) {
            if(arr[j] > arr[i]){
                max++;
                System.out.println(arr[i] +"\t"+arr[j]);
            }else{
                if(oldMax < max){
                    oldMax = max;
                }
                max = 1;
            }
        }
        System.out.println("The longest increasing subsequence count: "+oldMax);
    }
}
