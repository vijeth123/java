package com.vijeth.geeksforgeeks.datastructures.linkedlist;

import java.util.LinkedList;

class LRUCache{
    private int capacity;
    private LinkedList<Integer> linkedList;

    public LRUCache(int capacity){
        this.capacity = capacity;
        linkedList = new LinkedList<>();
    }

    public void refer(Integer element){
        if(!linkedList.contains(element)){
            if(linkedList.size() == capacity){
                linkedList.pollLast();
            }
            linkedList.push(element);
        }else{
            linkedList.remove(element);
            linkedList.push(element);
        }
    }

    public void display(){
        linkedList.stream().forEach(e -> {
            System.out.println(e);
        });
    }
}


public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }
}
