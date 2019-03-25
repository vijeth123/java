package com.vijeth.geeksforgeeks.datastructures.string;

public class LongestCommonAnagramSubsequence {

    public static void findLongestCommonAnagramSubsequence(String[] input){

        int[][] alphabetCountArray = new int[input.length][26];

        for(int i = 0; i < input.length; i++){
            char[] charArray = input[i].toCharArray();

            for(int j = 0;j<charArray.length;j++){
                alphabetCountArray[i][charArray[j] - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            int min = alphabetCountArray[0][i];

            for(int j = 1;j < input.length;j++){
                min = Math.min(min, alphabetCountArray[j][i]);
            }

            while(min > 0){
                System.out.print(Character.valueOf((char)(i + 'a')));
                min--;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String[] input1 = { "geeks", "esrka", "efrsk" };
        findLongestCommonAnagramSubsequence(input1);

        String[] input2 = { "loo", "lol", "olive" };
        findLongestCommonAnagramSubsequence(input2);
    }
}
