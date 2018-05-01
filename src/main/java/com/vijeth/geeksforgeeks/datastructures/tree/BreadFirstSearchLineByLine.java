package com.vijeth.geeksforgeeks.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstSearchLineByLine {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static void printTreeLineByLine(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(true){
            int nodeCount = queue.size();
            if(nodeCount == 0){
                break;
            }
            while(nodeCount > 0) {
                Node temp = queue.poll();
                System.out.print(temp.data + "\t");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        System.out.println("Print line by line of Bread-First traversal of binary tree is - ");
        printTreeLineByLine(root);
    }
}
