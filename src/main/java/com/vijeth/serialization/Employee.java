package com.vijeth.serialization;

import java.io.Serializable;

class Employee implements Serializable {

    private int id;
    private String name;
    private transient int salary;
    static int count = 0;
    private char[] password;

    private static final long serialVersionUID = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}