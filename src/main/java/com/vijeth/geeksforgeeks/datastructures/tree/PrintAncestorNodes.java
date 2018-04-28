package com.vijeth.geeksforgeeks.datastructures.tree;

public class PrintAncestorNodes {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static boolean printAncestors(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }

        if(printAncestors(node.left, data) || printAncestors(node.right, data)){
            System.out.println(node.data);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        printAncestors(root, 7);
    }

}
