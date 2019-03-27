package com.vijeth.geeksforgeeks.datastructures.string;


public class RomanToDecimal {

    public static int romanToDecimalMapper(char s){
        switch (s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int convertToDecimal(String roman){
        char[] romanChars = roman.toCharArray();
        int result = 0;

        for(int i = 0;i < romanChars.length; i++){
            int current = romanToDecimalMapper(romanChars[i]);

            if(i+1 < romanChars.length) {
                int next = romanToDecimalMapper(romanChars[i+1]);
                if (current >= next) {
                    result = result + current;
                } else {
                    result = result + (next - current);
                    i++;
                }
            }else{
                result = result + current;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertToDecimal("MCMIV"));
    }
}
