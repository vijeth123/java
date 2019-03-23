package com.vijeth.geeksforgeeks.datastructures.string;

import java.util.*;

public class PrintAnagramsTogether {

    private static void printAnagramsTogether(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            char[] tempArr = arr[i].toCharArray();
            Arrays.sort(tempArr);
            String sortedString = new String(tempArr);

            if(map.containsKey(sortedString)){
                List<String> list = map.get(sortedString);
                list.add(arr[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(sortedString, list);
            }

        }

        map.forEach((k, v) -> {
            v.stream().forEach(System.out::println);
        } );

    }

    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act"};
        printAnagramsTogether(arr);
    }

}
