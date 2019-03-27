package com.vijeth.geeksforgeeks.datastructures.string;

public class ReverseStringUsingRecursion {

    public static String reverse(String s){
        if(s.length() == 1){
            return s;
        }
        return s.charAt(s.length()-1) + reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(reverse("Vijeth"));
    }
}
