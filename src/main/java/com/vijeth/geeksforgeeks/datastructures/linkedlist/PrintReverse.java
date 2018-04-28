package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class PrintReverse {

    private static class Node{
        int data;
        Node next;

        public Node(int data){
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
            while(temp !=null){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
            System.out.println("\n");
        }


        public void printReverse(Node node){
            if(node == null){
                return;
            }
            printReverse(node.next);
            System.out.print(node.data+"\t");
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

        System.out.println("\n\n");
        linkedList.printReverse(linkedList.head);
    }
}
