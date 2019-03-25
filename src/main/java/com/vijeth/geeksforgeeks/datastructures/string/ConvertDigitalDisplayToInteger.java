package com.vijeth.geeksforgeeks.datastructures.string;

public class ConvertDigitalDisplayToInteger {

    public static void getDigits(String s) {

        String[] lines = s.split("\n");

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < lines[0].length(); k += 3) {

            for (int i = 0; i < lines.length; i++) {
                char[] charArray = lines[i].toCharArray();
                for (int j = k; j < k + 3 && j < lines[i].length(); j++) {
                    sb.append(charArray[j]);
                }
            }
            printDigit(sb.toString());
            sb.setLength(0);
        }
    }

    public static void printDigit(String digit) {
        switch (digit) {
            case ".....|..|":
                System.out.print("1");
                break;

            case "._.._||_.":
                System.out.print("2");
                break;

            case "._.._|._|":
                System.out.print("3");
                break;

            case "...|_|..|":
                System.out.print("4");
                break;

            default:
                System.out.println("Invalid input");
                break;
        }
    }


    public static void main(String[] args) {

        String s1 = "...._.._....\n" +
                    "..|._|._||_|\n" +
                    "..||_.._|..|\n";

        String s2 = "...._.._....\n" +
                    "|_|._|._|..|\n" +
                    "..|._||_...|\n";

        getDigits(s1);
        System.out.println();
        getDigits(s2);
    }
}

