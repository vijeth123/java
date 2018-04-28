package com.vijeth.geeksforgeeks.datastructures.stack;

public class StringReverse {

    private static class Stack{

        private char[]arr = new char[20];
        int top = -1;

        public void push(char c){
            arr[++top] = c;
        }

        public char pop(){
            if(top < 0){
                return arr[top];
            }
            return arr[top--];
        }

    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push('V');
        stack.push('I');
        stack.push('J');
        stack.push('E');
        stack.push('T');
        stack.push('H');

        while(stack.top >= 0){
            System.out.println(stack.pop());
        }

    }
}
