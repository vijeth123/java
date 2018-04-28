package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class LengthOfLinkedList {

    private static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    private static class LinkedList{
        Node head;
        public void insert(int data){
            Node node = new Node(data);
            if(head == null){
                head = node;
                return;
            }
            node.next = head;
            head = node;
        }

        public void print(){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        private int getLength(Node temp, int length){
            if(temp == null){
                return length;
            }
            return getLength(temp.next, length+1);
        }

        public int getLength(){
            return getLength(head, 0);
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

        linkedList.print();

        System.out.println("Length of linkedlist is: "+linkedList.getLength());
    }


}
