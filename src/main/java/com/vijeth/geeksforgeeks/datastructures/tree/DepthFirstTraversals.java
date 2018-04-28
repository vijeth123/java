package com.vijeth.geeksforgeeks.datastructures.tree;

public class DepthFirstTraversals {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    private static void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+"\t");
        inorder(node.right);
    }

    private static void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+"\t");
        preorder(node.left);
        preorder(node.right);
    }

    private static void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+"\t");
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

        System.out.println("Inorder: ");
        inorder(root);

        System.out.println("\n\nPreorder: ");
        preorder(root);

        System.out.println("\n\nPostorder: ");
        postorder(root);

        System.out.println("\n\nThe depth of this tree is: "+depth(root));
    }
}
