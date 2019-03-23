package com.vijeth.geeksforgeeks.datastructures.string;

public class CheckAnagram {

    public static boolean areAnagrams(String s1, String s2){

        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }

        int[] countArrayOfS1 = new int[26];
        int[] countArrayOfS2 = new int[26];

        for(int i=0;i<s1.length();i++){
            countArrayOfS1[s1.charAt(i) - 'A']++;
            countArrayOfS2[s2.charAt(i) - 'A']++;
        }

        for(int i=0;i<countArrayOfS1.length;i++){
            if(countArrayOfS1[i] != countArrayOfS2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("LISTEN", "SILENT"));
        System.out.println(areAnagrams("TRIANGLE", "INTEGRAL"));
    }
}
