package com.vijeth.design.pattern.creational;

import java.util.ArrayList;
import java.util.List;

class EmployeeNames{

    private List<String> names = new ArrayList<>();

    public void loadEmployeeNames() {
        names.add("Vijeth");
        names.add("Bharath");
        names.add("Prasanna");
        names.add("Mahesh");
        names.add("Jags");
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> clonedNames = new ArrayList<>();
        names.stream().forEach(clonedNames::add);
        return clonedNames;
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        EmployeeNames employeeNames = new EmployeeNames();
        employeeNames.loadEmployeeNames();

        List<String> fusionTeam = (List<String>)employeeNames.clone();
        fusionTeam.remove("Jags");
        System.out.println("\n\nFusion team:");
        fusionTeam.stream().forEach(System.out::println);

        List<String> ttTeam = (List<String>)employeeNames.clone();
        ttTeam.add("Sri");
        System.out.println("\n\nTT team:");
        ttTeam.stream().forEach(System.out::println);
    }
}
