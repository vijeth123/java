package com.vijeth.geeksforgeeks.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchPrintReverse {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static void printBreadthFirstReverse(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Stack<Node> stack = new Stack<>();

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            stack.push(temp);

            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+"\t");
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

        System.out.println("Print reverse of Bread-First traversal of binary tree is - ");
        printBreadthFirstReverse(root);
    }

}
