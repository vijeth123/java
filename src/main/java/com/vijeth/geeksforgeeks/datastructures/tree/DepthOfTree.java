package com.vijeth.geeksforgeeks.datastructures.tree;

public class DepthOfTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static int depth(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = 1 + depth(node.left);
        int rightSum = 1 + depth(node.right);
        return Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);

        Node c = new Node(4);
        Node d = new Node(5);

        Node e = new Node(6);
        Node f = new Node(7);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        d.left = e;
        d.right = f;

        System.out.println("\n\nThe depth of this tree is: "+depth(root));
    }
}
