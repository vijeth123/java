package com.vijeth.interview;

public class FindLargestNumberCombination {

    public static int findLargestNumber(int input){

        char[] inputCharArr = Integer.toString(input).toCharArray();

        int[] count = new int[10];

        for(int i=0;i<inputCharArr.length;i++){
            count[inputCharArr[i] - '0']++;
        }

        int x = 1;
        int largestNumber = 0;

        for(int i=0;i<count.length;i++){
            while(count[i] > 0){
                largestNumber = largestNumber + (i * x);
                x*=10;
                count[i]--;
            }
        }
        return largestNumber;
    }

    public static void main(String[] args) {
        System.out.println("Largest number is: "+findLargestNumber(1434));
    }

}
