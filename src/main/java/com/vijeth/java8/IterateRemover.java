package com.vijeth.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IterateRemover {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Vijeth", "Bharath", "Facebook", "Prasanna", "YouTube");

        IterateRemover iterateRemover = new IterateRemover();

        System.out.println("Before removal:");
        iterateRemover.print(names);

        iterateRemover.removeSomeSites(names);

        System.out.println("\n\nAfter removal:");
        iterateRemover.print(names);

        System.out.println("\n\nAfter removal for second time:");
        names.removeIf(name -> name.equals("YouTube"));
        iterateRemover.print(names);

    }

    private void removeSomeSites(List<String> list){
        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
            String name = iterator.next();
            if(name.equals("Facebook")){
                iterator.remove();
            }
        }
    }

    private void print(List<String> list){
        list.stream().forEach(name -> System.out.print(name+"\t"));
    }
}
