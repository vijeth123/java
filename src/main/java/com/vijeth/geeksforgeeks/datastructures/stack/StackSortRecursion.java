package com.vijeth.geeksforgeeks.datastructures.stack;

import java.util.Enumeration;
import java.util.Stack;

public class StackSortRecursion {

    private static void sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int x = stack.pop();
        sort(stack);
        insert(stack, x);
    }

    private static void insert(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }

        int top = stack.pop();
        stack.push(top);

        if(x > top){
            stack.push(x);
            return;
        }

        top = stack.pop();
        insert(stack, x);
        stack.push(top);

    }

    private static void display(Stack<Integer> stack){
        Enumeration<Integer> enumeration = stack.elements();
        while(enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(40);
        stack.push(20);
        stack.push(50);

        System.out.println("Before sorting: ");
        display(stack);

        sort(stack);

        System.out.println("After sorting: ");
        display(stack);
    }

}
