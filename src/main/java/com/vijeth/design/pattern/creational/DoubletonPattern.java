package com.vijeth.design.pattern.creational;

import java.util.Random;

class Doubleton{
    private Doubleton(){}

    private static class DoubletonHolder{
        private static final Doubleton INSTANCE_1 = new Doubleton();
        private static final Doubleton INSTANCE_2 = new Doubleton();
    }

    public static Doubleton getInstance(){
        if(new Random().nextInt() % 2 == 0){
            return DoubletonHolder.INSTANCE_1;
        }else{
            return DoubletonHolder.INSTANCE_2;
        }
    }
}


public class DoubletonPattern {
    public static void main(String[] args) {
        System.out.println(Doubleton.getInstance().hashCode());
        System.out.println(Doubleton.getInstance().hashCode());
        System.out.println(Doubleton.getInstance().hashCode());
        System.out.println(Doubleton.getInstance().hashCode());
        System.out.println(Doubleton.getInstance().hashCode());
    }
}
