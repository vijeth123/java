package com.vijeth.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee{
    private Integer id;
    private String name;

    public Employee(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Java8Sort {
    public static void main(String[] args) {

        /*
         *  String-Sort
         */
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "vijeth", "Menaka", "mohan", "Shreyas", "Madhu");
        names.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-Insensitive order:"+ names);

        names.sort(Comparator.naturalOrder());
        System.out.println("\nNatural order:"+ names);


        /*
         *   Employee-Sort
         */
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees, new Employee(10,"Bharath"),
                                      new Employee(50,"Prasanna"),
                                      new Employee(30,"Mahesh"),
                                      new Employee(20,"Vijeth"),
                                      new Employee(40,"Allen"));

        System.out.println("\nBefore sorting:");
        System.out.println(employees);

        System.out.println("\n\nSorted by id:");
        employees.sort(Comparator.comparing(Employee::getId));
        System.out.println(employees);

        System.out.println("\n\nSorted by name:");
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println(employees);

        System.out.println("\n\nReverse sorted by name:");
        employees.sort(Comparator.comparing(Employee::getName).reversed());
        System.out.println(employees);
    }
}
