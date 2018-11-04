package com.vijeth.geeksforgeeks.algorithms;

public class LargestSumContiguousSubarray {

    private static int maxSubArraySum(int a[]){
        int ending_here = 0;
        int sum = 0;

        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum > ending_here){
                ending_here = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return ending_here;
    }

    public static void main(String[] args)
    {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3, 50, -20 };
        int n = a.length;
        System.out.println("Largest sum of contiguous array: "+ maxSubArraySum(a));
    }
}
