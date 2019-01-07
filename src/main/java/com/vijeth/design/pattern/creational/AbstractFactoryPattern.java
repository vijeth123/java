package com.vijeth.design.pattern.creational;

abstract class ElectronicItem {
    private String name;
    private int price;

    public ElectronicItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class KeyBoard extends ElectronicItem {
    public KeyBoard(String name, int price) {
        super(name, price);
    }
}

class Mouse extends ElectronicItem {
    public Mouse(String name, int price) {
        super(name, price);
    }
}

abstract class ElectronicsAbstractFactory {
    protected String name;
    protected int price;

    public ElectronicsAbstractFactory(String name, int price) {
        this.name = name;
        this.price = price;
    }
    abstract public ElectronicItem getElectronicItem();
}


class KeyBoardFactory extends ElectronicsAbstractFactory {

    public KeyBoardFactory(String name, int price){
        super(name, price);
    }

    @Override
    public ElectronicItem getElectronicItem() {
        return new KeyBoard(name, price) ;
    }
}

class MouseFactory extends ElectronicsAbstractFactory {

    public MouseFactory(String name, int price){
        super(name, price);
    }

    @Override
    public ElectronicItem getElectronicItem() {
        return new Mouse(name, price) ;
    }
}

class ElectronicsFactory{
    public static ElectronicItem getElectronicItem(ElectronicsAbstractFactory electronicsAbstractFactory){
        return electronicsAbstractFactory.getElectronicItem();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        System.out.println(ElectronicsFactory.getElectronicItem(new KeyBoardFactory("Lenovo", 13000)));
        System.out.println(ElectronicsFactory.getElectronicItem(new MouseFactory("Logitech", 850)));
    }
}
