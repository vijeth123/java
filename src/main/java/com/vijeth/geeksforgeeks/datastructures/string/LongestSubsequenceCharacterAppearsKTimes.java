package com.vijeth.geeksforgeeks.datastructures.string;

public class LongestSubsequenceCharacterAppearsKTimes {


    public static String getLongestSubsequence(String words, int k){

        int[] frequency = new int[26];

        char[] charArray = words.toCharArray();

        for(int i=0;i < charArray.length; i++){
            frequency[charArray[i] - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i < charArray.length; i++){
            if(frequency[charArray[i] - 'a'] >= k){
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(getLongestSubsequence("geeksforgeeks", 2));
        System.out.println(getLongestSubsequence("aabbaabacabb", 5));
    }
}
