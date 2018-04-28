package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class ReverseLinkedList {
    private static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    private static class LinkedList {
        Node head;

        public void insert(int data) {
            Node node = new Node(data);
            if (head == null) {
                head = node;
                return;
            }
            node.next = head;
            head = node;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public void reverse(){
            Node prev = null;
            Node curr = head;
            Node next = null;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);
        linkedList.insert(60);

        System.out.println("Before reverse");
        linkedList.print();

        System.out.println("\nAfter reverse");
        linkedList.reverse();
        linkedList.print();

    }
}
