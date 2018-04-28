package com.vijeth.serialization;

import java.io.File;

public class SerializationTestNormal {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("Vijeth");
        employee.setSalary(40000);
        Employee.setCount(Employee.getCount() + 1);

        File file = new File("hello.txt");
        SerializationUtil.serialize(employee, file);
        System.out.println("Serialized employee: "+employee);

        employee = (Employee)SerializationUtil.deserialize(file);
        System.out.println("Derialized employee: "+employee);
    }
}
