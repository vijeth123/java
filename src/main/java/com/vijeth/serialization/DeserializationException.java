package com.vijeth.serialization;

import java.io.File;

public class DeserializationException {
    public static void main(String[] args) throws Exception {
        Employee employee = (Employee)SerializationUtil.deserialize(new File("hello.txt"));
        System.out.println("Deserialized employee: "+employee);
    }
}
