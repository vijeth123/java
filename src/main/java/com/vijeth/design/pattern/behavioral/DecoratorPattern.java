package com.vijeth.design.pattern.behavioral;


interface IceCream{
    public String makeIceCream();
}

class SimpleIceCream implements IceCream{
    @Override
    public String makeIceCream() {
        return "Simple Ice-cream..";
    }
}

abstract class Decorator implements IceCream{
    protected IceCream specialIceCream;

    public Decorator(IceCream specialIceCream) {
        this.specialIceCream = specialIceCream;
    }
}

class NutsIceCream extends Decorator{
    public NutsIceCream(IceCream specialIceCream) {
        super(specialIceCream);
    }

    @Override
    public String makeIceCream() {
        return specialIceCream.makeIceCream() + addNuts();
    }

    private String addNuts(){
        return " + Adding Nuts..";
    }
}

class HoneyIceCream extends Decorator{
    public HoneyIceCream(IceCream specialIceCream) {
        super(specialIceCream);
    }

    @Override
    public String makeIceCream() {
        return specialIceCream.makeIceCream() + addHoney();
    }

    private String addHoney(){
        return " + Adding Honey..";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        IceCream iceCream = new HoneyIceCream(new NutsIceCream(new SimpleIceCream()));
        System.out.println(iceCream.makeIceCream());
    }
}
