package com.vijeth.interview;

interface A{
    public void sayHi();
}

interface B{
    public void sayHi();
}

class MyClass implements A, B{
    @Override
    public void sayHi() {
        System.out.println("Hi");
    }
}

public class DifferentInterfacesSameMethod {
    public static void main(String[] args) {
        new MyClass().sayHi();
    }
}
