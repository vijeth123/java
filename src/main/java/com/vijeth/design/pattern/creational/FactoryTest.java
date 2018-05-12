package com.vijeth.design.pattern.creational;

abstract class Computer{
    private String ram;
    private String hdd;

    public Computer(String ram, String hdd) {
        this.ram = ram;
        this.hdd = hdd;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computer='" + this.getClass() + '\'' +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                '}';
    }

    public abstract int getPrice();
}

class PC extends Computer{
    public PC(String ram, String hdd) {
        super(ram, hdd);
    }

    @Override
    public int getPrice() {
        return 50000;
    }
}

class Server extends Computer{
    public Server(String ram, String hdd) {
        super(ram, hdd);
    }
    @Override
    public int getPrice() {
        return 10000000;
    }
}

class ComputerFactory{
    public Computer getComputer(String type){
        switch(type) {
            case "PC": return new PC("4G", "100G");
            case "Server": return new Server("10G", "10T");
            default: return null;
        }
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        System.out.println(computerFactory.getComputer("PC"));
        System.out.println(computerFactory.getComputer("Server"));
    }
}
