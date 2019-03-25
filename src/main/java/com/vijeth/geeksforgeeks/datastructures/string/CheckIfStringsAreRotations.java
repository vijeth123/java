package com.vijeth.geeksforgeeks.datastructures.string;

public class CheckIfStringsAreRotations {

    public static void checkIfRotations(String s1, String s2){

        if(s1 == null || s2 == null || s1.length() != s2.length()){
            System.out.println("Invalid strings");
            return;
        }

        String temp = s1 + s1;
        int n = s1.length();

        for(int i = 1; i < n-1; i++){
            String substring = temp.substring(i, i + n);

            if(substring.equals(s2)){
                System.out.println(s1 +" and "+s2+" are rotations of each other");
                return;
            }

        }
        System.out.println(s1 +" and "+s2+" are NOT rotations of each other");
    }

    public static void main(String[] args) {
        checkIfRotations("ABACD", "CDABA");
        checkIfRotations("GEEKS", "EKSGE");
        checkIfRotations("ABCD", "DACB");
    }
}
