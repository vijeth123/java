package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class DeleteFromLinkedList {

    private static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    private static class LinkedList{

        private Node head;

        public void insert(int data){
            Node node = new Node(data);
            if(head == null){
                head = node;
            }else {
                node.next = head;
                head = node;
            }
        }

        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
        }

        public void delete(int key){
            if(head == null){
                return;
            }
            if(head.data == key){
                head = head.next;
                return;
            }

            Node temp = head;
            Node prev = null;
            while(temp!=null && temp.data != key){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);

        System.out.println("Before deletion");
        linkedList.print();

        int key = 20;
        System.out.println("\n\nAfter deleting "+key);
        linkedList.delete(key);
        linkedList.print();
    }
}
