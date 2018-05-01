package com.vijeth.geeksforgeeks.datastructures.tree;

public class SizeOfTree {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }


    private static int sizeOfTree(Node node){
        if(node == null){
            return 0;
        }
        return 1 + sizeOfTree(node.left) + sizeOfTree(node.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Size of the tree is: "+sizeOfTree(root));
    }

}
