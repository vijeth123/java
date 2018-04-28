package com.vijeth.java8;

import java.util.ArrayList;
import java.util.Collections;
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

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees, new Employee(10,"Bharath"), new Employee(50,"Prasanna"), new Employee(30,"Mahesh"),
                new Employee(20,"Vijeth"),
                new Employee(40,"Allen"));

        System.out.println("Before sorting:");
        employees.forEach(System.out::println);

        System.out.println("\n\nSorted by id:");
        Collections.sort(employees, (e1, e2) -> e1.getId().compareTo(e2.getId()));
        employees.forEach(System.out::println);

        System.out.println("\n\nSorted by name:");
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);
    }
}
