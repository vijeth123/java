package com.vijeth.geeksforgeeks.datastructures.tree;

public class MaximumWidthOfTree {

    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    private static int getHeight(Node node){
        if(node == null){
            return 0;
        }

        int leftTreeHeight = 1 + getHeight(node.left);
        int rightTreeHeight = 1 + getHeight(node.right);

        return Math.max(leftTreeHeight, rightTreeHeight);
    }

    private static int getWidth(Node node, int i){
        if(node == null){
            return 0;
        }
        if(i == 1){
            return 1;
        }
        return getWidth(node.left, i-1) + getWidth(node.right, i-1);
    }

    private static int getMaximumWidth(Node node){
        int height = getHeight(node);
        int maxWidth = 0;
        int width = 0;

        for(int i=0; i<height; i++){
            width = getWidth(node, i);

            if(width > maxWidth){
                maxWidth = width;
            }

        }
        return width;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println("The height of the tree is: "+getHeight(root));
        System.out.println("The maximum width of the tree is: "+getMaximumWidth(root));
    }

}
