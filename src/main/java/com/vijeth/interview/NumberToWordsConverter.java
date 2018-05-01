package com.vijeth.interview;

public class NumberToWordsConverter {

    private static String[] zeroToNineteen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                              "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static String[] singleZeroNumbers = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    private static String convert(int num){
        String words = "";

        if(num < 100){
            if(num < 20) {
                words = zeroToNineteen[num];
            }else{
                words = singleZeroNumbers[num/10] +" "+ zeroToNineteen[num % 10];
            }
            return words;
        }

        if(num < 1000){
            words = convert(num/100) + " Hundred " + convert(num % 100);
            return words;
        }

        if(num < 100000){
            words = convert(num/1000) + " Thousand " + convert(num % 1000);
            return words;
        }

        if(num < 10000000){
            words = convert(num/100000) + " Lakh " + convert(num % 100000);
            return words;
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.println(convert(7802500));
    }
}
