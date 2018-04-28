package com.vijeth.geeksforgeeks.datastructures.tree;

public class PrintNodesKDistance {
    
    private static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
        }
    }
    
    private static void printNodesAtDistance(Node node, int k){
        if(node == null){
            return;
        }
        if(k == 0){
            System.out.print(node.data+"\t");
            return;
        }
        printNodesAtDistance(node.left, k-1);
        printNodesAtDistance(node.right, k-1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);

        printNodesAtDistance(root, 2);
    }
    
}
