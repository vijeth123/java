package com.vijeth.design.pattern.behavioral;

interface Decorator{
    public void prepare();
}

class Icecream implements Decorator{
    @Override
    public void prepare() {
        System.out.println("Preparing plain ice-cream!");
    }
}

class Nuts implements Decorator{
    private Decorator decorator;

    public Nuts(Decorator decorator){
        this.decorator = decorator;
    }

    @Override
    public void prepare(){
        this.decorator.prepare();
        System.out.println(" Adding nuts!");
    }
}

class Honey implements Decorator{
    private Decorator decorator;

    public Honey(Decorator decorator){
        this.decorator = decorator;
    }

    @Override
    public void prepare(){
        this.decorator.prepare();
        System.out.println(" Adding honey!");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Decorator icecream = new Honey(new Nuts(new Icecream()));
        icecream.prepare();
    }
}
