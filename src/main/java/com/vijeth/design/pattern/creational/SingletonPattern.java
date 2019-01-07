package com.vijeth.design.pattern.creational;

import java.io.*;

class EagerSingleton implements Serializable, Cloneable{
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

    protected Object readResolve(){
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }
}

class DoubleCheckedSingleton{
    private static volatile DoubleCheckedSingleton instance = null;

    private DoubleCheckedSingleton(){}

    public static DoubleCheckedSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

class BillPugh{
    private BillPugh(){}

    private static class Holder{
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance(){
        return Holder.INSTANCE;
    }
}

class StaticSingleton{
    private static final StaticSingleton INSTANCE;
    static{
        INSTANCE = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return INSTANCE;
    }
}

enum EnumSingleton{
    INSTANCE;
}

public class SingletonPattern {
    public static void main(String[] args) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        System.out.println("\n******************************************************************\n");

        new ObjectOutputStream(new FileOutputStream(new File("C:\\temp\\hello.txt"))).writeObject(EagerSingleton.getInstance());
        System.out.println("Eager Singleton:            "+ EagerSingleton.getInstance().hashCode());
        System.out.println("Eager Singleton Serialized: "+ new ObjectInputStream(new FileInputStream(new File("C:\\temp\\hello.txt"))).readObject().hashCode());
        System.out.println("Eager Singleton Cloned:     "+ EagerSingleton.getInstance().clone().hashCode());

        System.out.println("\n******************************************************************\n");

        System.out.println("Double-Checked-Singleton: "+ DoubleCheckedSingleton.getInstance().hashCode());
        System.out.println("Double-Checked-Singleton: "+ DoubleCheckedSingleton.getInstance().hashCode());

        System.out.println("\n******************************************************************\n");

        System.out.println("Bill-Pugh Singleton: "+ BillPugh.getInstance().hashCode());
        System.out.println("Bill-Pugh Singleton: "+ BillPugh.getInstance().hashCode());

        System.out.println("\n******************************************************************\n");

        System.out.println("Static-Singleton: "+ StaticSingleton.getInstance().hashCode());
        System.out.println("Static-Singleton: "+ StaticSingleton.getInstance().hashCode());

        System.out.println("\n******************************************************************\n");

        System.out.println("Enum Singleton: "+ EnumSingleton.INSTANCE.hashCode());
        System.out.println("Enum Singleton: "+ EnumSingleton.INSTANCE.hashCode());

        System.out.println("\n******************************************************************\n");

    }
}
