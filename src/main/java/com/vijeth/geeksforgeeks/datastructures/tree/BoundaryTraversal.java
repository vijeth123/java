package com.vijeth.geeksforgeeks.datastructures.tree;

public class BoundaryTraversal {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static void printLeaves(Node node){
        if(node != null) {
            printLeaves(node.left);
            if (node.left == null && node.right == null) {
                System.out.print(node.data+"\t");
            }
            printLeaves(node.right);
        }
    }

    private static void printLeftBoudaryTopDown(Node node){
        if(node.left != null){
            System.out.print(node.data+"\t");
            printLeftBoudaryTopDown(node.left);
        }else if(node.right != null){
            System.out.println(node.data+"\t");
            printLeftBoudaryTopDown(node.right);
        }
    }

    private static void printRightBoundaryBottomUp(Node node){
        if(node.right != null){
            printRightBoundaryBottomUp(node.right);
            System.out.println(node.data);
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
        System.out.println("\n\nPrinting left boundary top-down:");
        printLeftBoudaryTopDown(root);
        System.out.println("\n\nPrinting leaves:");
        printLeaves(root);
        System.out.println("\n\nPrinting right boundary bottom-up:");
        printRightBoundaryBottomUp(root);
    }
}
