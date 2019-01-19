package com.vijeth.interview;

interface A{
    public void sayHi();

    default public void sayHello(){
        System.out.println("A's default method 'sayHello'");
    }

    default public void sayA(){
        System.out.println("A's specific default method 'sayA'");
    }

    public static void sayYes(){
        System.out.println("A's static method 'sayYes'");
    }
}

interface B{
    public void sayHi();

    default public void sayHello(){
        System.out.println("B's default method 'sayHello'");
    }

    public static void sayYes(){
        System.out.println("B's static method 'sayYes'");
    }
}

class MyClass implements A, B{
    @Override
    public void sayHi() {
        System.out.println("MyClass sayHi");
    }

    @Override
    public void sayHello() {
        System.out.println("Since this default method is common in both the interfaces- A and B, you have to provide the implementation here.");
    }

    public static void sayYes(){
        System.out.println("MyClass's static method 'sayYes'");
    }

}

public class DifferentInterfacesSameMethod {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.sayHi();
        myClass.sayHello();
        myClass.sayA();
        A.sayYes();
        B.sayYes();
        MyClass.sayYes();
    }
}
