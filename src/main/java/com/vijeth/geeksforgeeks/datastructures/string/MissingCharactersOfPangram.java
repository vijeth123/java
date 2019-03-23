package com.vijeth.geeksforgeeks.datastructures.string;

public class MissingCharactersOfPangram {

    public static void printMissingCharactersOfPangram(String s){
        boolean[] isLetterPresent = new boolean[26];

        char[] charArray = s.toCharArray();

        for(int i=0;i < charArray.length; i++){
            if(charArray[i] >= 'a' && charArray[i] <= 'z'){
                isLetterPresent[charArray[i] - 'a' ] = true;
            }else if(charArray[i] >= 'A' && charArray[i] <= 'Z'){
                isLetterPresent[charArray[i] - 'A' ] = true;
            }
        }

        for(int i=0;i < isLetterPresent.length; i++){
            if(!isLetterPresent[i]){
                System.out.println(Character.valueOf((char)(i + 'a')));
            }
        }
    }

    public static void main(String[] args) {
        printMissingCharactersOfPangram("The quick brown fox jumps over the dog");
    }

}
