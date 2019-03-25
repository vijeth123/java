package com.vijeth.geeksforgeeks.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class CountWordsThatAppearTwice {

    private static void findWordsThatAppearTwice(String[] words){

        Map<String, Integer> map = new HashMap<>();

        for(String word: words){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }

        System.out.println("The words that are repeated exactly twice are:");
        map.forEach((k,v) -> {
            if(v == 2){
                System.out.println(k);
            }
        } );

    }

    public static void main(String[] args) {
        String[] input1 = {"Hi", "Om", "Om", "Shankar", "Hi", "Tripathi",
                "Tom", "Jerry", "Jerry", "Hi"};

        findWordsThatAppearTwice(input1);
    }
}
