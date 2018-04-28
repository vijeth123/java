package com.vijeth.geeksforgeeks.datastructures.stack;

public class StackImplementation {

    public static class Stack{

        private int arr[];
        int top = -1;
        final int MAX;

        public Stack(final int MAX){
            arr = new int[MAX];
            this.MAX = MAX;
        }

        public boolean push(int data){
            if(top == MAX-1){
                System.out.println("Stack is full..!!");
                return false;
            }
            arr[++top] = data;
            return true;
        }

        public int pop(){
            if(top == -1){
                System.out.println("\nStack is empty..!!");
                return -1;
            }
            int data = arr[top--];
            return data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        for(int i=10;i<=120;i+=10){
            stack.push(i);
        }

        for(int i=0;i<13;i++){
            System.out.print(stack.pop()+"\t");
        }

    }

}
