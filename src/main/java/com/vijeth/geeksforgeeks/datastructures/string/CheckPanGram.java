package com.vijeth.geeksforgeeks.datastructures.string;

public class CheckPanGram {

    public static boolean isPanGram(String sentence){
        boolean[] booleans = new boolean[26];

        char[] arr = sentence.toCharArray();

        for(char c: arr){
            if(c >= 'a' && c <= 'z'){
                booleans[c - 'a'] = true;
            }else if(c >= 'A' && c <= 'Z'){
                booleans[c - 'A'] = true;
            }
        }

        for(boolean b: booleans){
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPanGram("The quick brown fox jumps over the lazy dog!!"));
        System.out.println(isPanGram("The quick brown fox jumps over the dog"));
    }
}
