package com.vijeth.geeksforgeeks.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public static void printLeftView(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int initialQueueSize = queueSize;

            while(queueSize > 0){
                Node dequeuedNode = queue.poll();

                if(queueSize == initialQueueSize) {
                    System.out.print(dequeuedNode.data + "  ");
                }
                if(dequeuedNode.left != null){
                    queue.add(dequeuedNode.left);
                }
                if(dequeuedNode.right != null){
                    queue.add(dequeuedNode.right);
                }
                queueSize--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /* Constructed binary tree is
              12
             /  \
           10     30
                 /  \
                25  40
       */

        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        System.out.println("Left view of this tree is: ");
        printLeftView(root);
    }

}
