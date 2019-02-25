package com.vijeth.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {

    private static class Employee{
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Vijeth"),
                                                 new Employee("Jags"),
                                                 new Employee("Bharath"),
                                                 new Employee("Prasanna"),
                                                 new Employee("Mahesh"));

        Map<String, Employee> map = employees.stream().filter(e -> e.getName() != "Jags").collect(Collectors.toMap(e -> e.getName(), e -> e ));

        map.entrySet().stream().forEach(entry ->{
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        });

    }
}
