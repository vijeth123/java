package com.vijeth.geeksforgeeks.algorithms;

public class Permutations {

    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0, str.length()-1);
    }

    private static void permute(String str, int left, int right){
        if(left == right){
            System.out.println(str);
        }else{
            for(int i=left;i<=right;i++){
                str = swap(str, left, i);
                permute(str, left+1, right);
                str = swap(str, left, i);
            }
        }
    }

    private static String swap(String str, int left, int right){
        char[] arr = str.toCharArray();
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        return new String(arr);
    }


}
