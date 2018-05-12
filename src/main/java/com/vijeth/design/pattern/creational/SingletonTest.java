package com.vijeth.design.pattern.creational;


class Singleton{

    private Singleton(){
    }

    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}


public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("Hashcode of singleton object is: "+ Singleton.getInstance());
        System.out.println("Hashcode of singleton object is: "+ Singleton.getInstance());
        System.out.println("Hashcode of singleton object is: "+ Singleton.getInstance());
        System.out.println("Hashcode of singleton object is: "+ Singleton.getInstance());
        System.out.println("Hashcode of singleton object is: "+ Singleton.getInstance());
    }
}
