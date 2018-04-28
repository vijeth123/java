package com.vijeth.geeksforgeeks.datastructures.stack;

import java.util.Stack;

public class NextGreaterElement {

    static void printNGE(int arr[]){
        int i = 0;
        Stack<Integer> stack = new Stack();
        int element, next;

        stack.push(arr[0]);

        for (i = 1; i < arr.length; i++){
            next = arr[i];

            if (!stack.isEmpty()){
                element = stack.pop();

                while (element < next){
                    System.out.println(element + " --> " + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }
                if (element > next) {
                    stack.push(element);
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()){
            element = stack.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 5, 1, 15, 30, 25, 40};
        printNGE(arr);
    }



}
