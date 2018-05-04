package com.vijeth.geeksforgeeks.datastructures.tree;

public class CountLeafNodes {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }


    private static int countLeafNodes(Node node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            System.out.println("Leaf node: "+node.data);
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    public static void main(String[] args) {
        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6

     */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The number of leaf nodes are: "+countLeafNodes(root));
    }


}
