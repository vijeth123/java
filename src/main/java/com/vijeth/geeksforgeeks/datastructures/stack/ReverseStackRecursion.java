package com.vijeth.geeksforgeeks.datastructures.stack;

import java.util.Enumeration;
import java.util.Stack;

public class ReverseStackRecursion {

    private Stack<Integer> stack1;

    public ReverseStackRecursion(){
        stack1 = new Stack<>();
    }

    public void push(int data){
        stack1.push(data);
    }

    public void dispStack(){
        Enumeration<Integer> enumeration =  stack1.elements();
        while(enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+"\t");
        }
        System.out.println();
    }


    public void reverse(){
        if(stack1.empty()){
            return;
        }
        Integer x = stack1.pop();
        reverse();
        insertAtBottom(x);
    }

    public void insertAtBottom(Integer a){
        if(stack1.empty()){
            stack1.push(a);
            return;
        }
        int x = stack1.pop();
        insertAtBottom(a);
        stack1.push(x);
    }

    public static void main(String[] args) {

        ReverseStackRecursion reverseStackRecursion = new ReverseStackRecursion();

        for(int i = 10;i<=50;i+=10){
            reverseStackRecursion.push(i);
        }
        reverseStackRecursion.dispStack();
        reverseStackRecursion.reverse();
        reverseStackRecursion.dispStack();
    }

}
