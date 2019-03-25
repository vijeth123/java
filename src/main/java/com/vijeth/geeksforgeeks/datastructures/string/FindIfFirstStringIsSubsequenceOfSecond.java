package com.vijeth.geeksforgeeks.datastructures.string;

public class FindIfFirstStringIsSubsequenceOfSecond {

    public static void findIsSubsequence(String first, String second){
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        int i = firstArr.length - 1;
        int j = secondArr.length - 1;

        while(i >= 0 && j >= 0){
            if(firstArr[i] == secondArr[j]){
                i--;
                j--;
            }else {
                j--;
            }
        }

        if(i == -1){
            System.out.println(first+" is a subsequence of: "+second);
        }else {
            System.out.println(first + " is NOT a subsequence of: " + second);
        }
    }

    public static void main(String[] args) {
        findIsSubsequence("AXY", "ADXCPY");
        findIsSubsequence("AXY", "YADXCP");
        findIsSubsequence("gksrek", "geeksforgeeks");
    }
}
