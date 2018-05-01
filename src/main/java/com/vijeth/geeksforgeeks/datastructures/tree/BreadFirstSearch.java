package com.vijeth.geeksforgeeks.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstSearch {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static void breadFirstSearch(Node root){
        Queue<Node> queue  = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+"\t");

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Bread-first traversal of binary tree is - ");
        breadFirstSearch(root);
    }



}
