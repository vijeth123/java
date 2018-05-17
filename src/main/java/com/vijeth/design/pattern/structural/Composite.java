package com.vijeth.design.pattern.structural;

import java.util.ArrayList;
import java.util.List;

interface Employee{
    public void add(Employee e);
    public void remove(Employee e);
    public void display();
}

class ExecutiveDirector implements Employee{
    private List<Employee> employees = new ArrayList<>();
    private String name;

    public ExecutiveDirector(String name){
        this.name = name;
    }

    @Override
    public void add(Employee e) {
        employees.add(e);
    }

    @Override
    public void remove(Employee e) {
        employees.remove(e);
    }

    @Override
    public void display() {
        System.out.println(this);
        employees.stream().forEach(Employee::display);
        System.out.println();
    }

    @Override
    public String toString() {
        return "ExecutiveDirector{" +
                "name='" + name + '\'' +
                '}';
    }
}

class VicePresident implements Employee{
    private List<Employee> employees = new ArrayList<>();
    private String name;

    public VicePresident(String name){
        this.name = name;
    }

    @Override
    public void add(Employee e) {
        employees.add(e);
    }

    @Override
    public void remove(Employee e) {
        employees.remove(e);
    }

    @Override
    public void display() {
        System.out.println(this);
        employees.stream().forEach(Employee::display);
        System.out.println();
    }

    @Override
    public String toString() {
        return "VicePresident{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Developer implements Employee{

    private String name;

    public Developer(String name){
        this.name = name;
    }

    @Override
    public void add(Employee e) {

    }

    @Override
    public void remove(Employee e) {

    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Composite {
    public static void main(String[] args) {
        Employee ed = new ExecutiveDirector("Ashish");

        Employee vp1 = new VicePresident("Surendra");
        Employee vp2 = new VicePresident("Bikram");

        Employee ad1 = new Developer("Vj");
        Employee ad2 = new Developer("Bg");
        Employee ad3 = new Developer("Parth");
        Employee ad4 = new Developer("Punith");

        ed.add(vp1);ed.add(vp2);
        vp1.add(ad1);vp1.add(ad2);
        vp2.add(ad3);vp2.add(ad4);

        ed.display();
    }
}
