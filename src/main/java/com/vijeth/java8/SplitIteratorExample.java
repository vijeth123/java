package com.vijeth.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SplitIteratorExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hi", "how are you?");
        Spliterator spliterator = list.spliterator();
        spliterator.forEachRemaining(System.out::println);
    }
}
