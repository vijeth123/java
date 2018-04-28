package com.vijeth.geeksforgeeks.datastructures.stack;

public class TwoStacksSingleArray {

    private int[] arr;
    int top1;
    int top2;

    int size = 0;

    public TwoStacksSingleArray(int size){
        arr = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }

    public boolean push1(int data){
        if(top1 >= top2 - 1){
            System.out.println("Stack1 overflow..!!");
            return false;
        }
        arr[++top1] = data;
        return true;
    }

    public int pop1(){
        if(top1 < 0){
            System.out.println("Stack1 empty..!!");
            return -1;
        }
        return arr[--top1];
    }

    public boolean push2(int data){
        if(top1 >= top2 - 1){
            System.out.println("Stack2 overflow..!!");
            return false;
        }
        arr[--top2] = data;
        return true;
    }

    public int pop2(){
        if(top2 >= size - 1){
            System.out.println("Stack2 empty..!!");
            return -1;
        }
        return arr[++top2];
    }

    public void disp(){
        System.out.println("\n");
        for(int a: arr){
            System.out.print(a+"\t");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        TwoStacksSingleArray stacksSingleArray = new TwoStacksSingleArray(10);

        for(int i=10;i<=40;i+=10){
            stacksSingleArray.push1(i);
        }
        stacksSingleArray.disp();

        for(int i=100;i<=160;i+=10){
            stacksSingleArray.push2(i);
        }

        stacksSingleArray.disp();

        System.out.println(stacksSingleArray.push1(99));
        System.out.println(stacksSingleArray.push2(99));

        stacksSingleArray.pop1();
        System.out.println(stacksSingleArray.push2(99));

        System.out.println(stacksSingleArray.pop2());
        System.out.println(stacksSingleArray.pop2());

        System.out.println(stacksSingleArray.push1(299));
        System.out.println(stacksSingleArray.push1(399));

    }

}
