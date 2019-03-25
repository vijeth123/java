package com.vijeth.geeksforgeeks.datastructures.string;


class MinimumRotationsToGetSameString {

    public static int findRotations(String str){
        String tmp = str + str;
        int n = str.length();

        for (int i = 1; i <= n; i++){
            String substring = tmp.substring(i, i+n);

            if (str.equals(substring)) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(findRotations("abc"));
        System.out.println(findRotations("aaaa"));
    }
}

