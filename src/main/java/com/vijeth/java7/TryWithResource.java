package com.vijeth.java7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResource {
    public static void main(String[] args) throws IOException {
        Files.write(Paths.get("hello.txt"), "Hi Vijeth..\nhow are you?".getBytes());
        try(BufferedReader reader = new BufferedReader(new FileReader("hello.txt"))){
            reader.lines().forEach(System.out::println);
        }
    }
}
