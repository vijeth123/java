package com.vijeth.geeksforgeeks.datastructures.stack;

import java.util.Stack;

public class SpecialStack{

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public SpecialStack(){
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int data){
        mainStack.push(data);

        if(minStack.empty()){
            minStack.push(data);
            return;
        }

        int min = minStack.pop();
        minStack.push(min);

        if(data < min){
            minStack.push(data);
        }
    }

    public int pop(){
        int x = mainStack.pop();
        int y = minStack.pop();

        if(x != y){
            minStack.push(y);
        }
        return x;
    }

    public int getMin(){
        int x = minStack.pop();
        minStack.push(x);
        return x;
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(50);
        specialStack.push(20);
        specialStack.push(30);
        specialStack.push(10);
        specialStack.push(40);

        System.out.println("Min: "+specialStack.getMin());
        System.out.println("Popped: "+specialStack.pop());

        System.out.println("Min: "+specialStack.getMin());
        System.out.println("Popped: "+specialStack.pop());

        System.out.println("Min: "+specialStack.getMin());
        System.out.println("Popped: "+specialStack.pop());

        System.out.println("Min: "+specialStack.getMin());
        System.out.println("Popped: "+specialStack.pop());
    }

}
