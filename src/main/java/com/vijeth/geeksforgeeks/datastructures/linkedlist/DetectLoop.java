package com.vijeth.geeksforgeeks.datastructures.linkedlist;

public class DetectLoop {

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

        public void insertLoop(){
            Node temp = head;
            int count = 0;
            while(count < 3){
                temp = temp.next;
                count++;
            }
            temp.next = head.next.next;
        }

        public boolean detectLoop(){
            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow){
                    return true;
                }
            }
            return false;
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

        linkedList.insertLoop();
        System.out.println("Loop is present: "+linkedList.detectLoop());

    }


}
