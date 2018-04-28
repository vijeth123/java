package com.vijeth.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        Files.write(Paths.get("hello.txt"), "Hi Vijeth!".getBytes());
    }
}
