package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class Merge2SortedLists {

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
    }

    public static LinkedList merge(LinkedList list1, LinkedList list2){
        Node head1 = list1.head;
        Node head2 = list2.head;

        Node head3 = null;
        Node tail = head3;

        while(true){
            if(head1 == null && head2 == null){
                break;
            }

            if(head1 == null){
                tail.next = head2;
                break;
            }
            if(head2 == null){
                tail.next = head1;
                break;
            }

            Node node = null;
            if(head1.data < head2.data){
                node = new Node(head1.data);
                head1 = head1.next;
            }else{
                node = new Node(head2.data);
                head2 = head2.next;
            }

            if(head3 == null){
                head3 = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
        }

        LinkedList list = new LinkedList();
        list.head = head3;
        return list;
    }

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        list1.insert(50);
        list1.insert(30);
        list1.insert(20);
        list1.print();

        LinkedList list2 = new LinkedList();
        list2.insert(60);
        list2.insert(40);
        list2.insert(10);
        list2.insert(5);
        list2.print();

        LinkedList mergedList = merge(list1, list2);
        mergedList.print();

    }

}
