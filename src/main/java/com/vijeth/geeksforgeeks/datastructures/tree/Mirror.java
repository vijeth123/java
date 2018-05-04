package com.vijeth.geeksforgeeks.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Mirror {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static void mirror(Node node){
        if(node == null){
            return;
        }
        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private static void printTreeLineByLine(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                Node polledNode = queue.poll();
                System.out.print(polledNode.data + "\t");

                if (polledNode.left != null) {
                    queue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
                queueSize--;
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        System.out.println("Original tree");
        printTreeLineByLine(root);
        mirror(root);
        System.out.println("\n\nConverted to Mirror tree");
        printTreeLineByLine(root);
    }

}
