package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class ReverseInGroups {

    private static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    private static class LinkedList{
        Node head;
        Node tail;

        public void insert(int data){
            Node node = new Node(data);
            if(head == null){
                head = node;
                tail = node;
                return;
            }
            tail.next = node;
            tail = node;
        }

        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println("\n");
        }

    }

    public static Node reverseInGroups(Node head, int n){
        Node prev = null;
        Node curr = head;
        Node next = null;

        int count = 0;
        while(curr != null && count < 3){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null){
            head.next = reverseInGroups(next, n);
        }
        return prev;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(80);
        list.insert(90);
        list.insert(100);

        list.print();

        LinkedList list2 = new LinkedList();
        list2.head = reverseInGroups(list.head, 3);

        list2.print();

    }

}
