package com.vijeth.geeksforgeeks.datastructures.tree;

public class RootToLeafSum {

    private static class Node{
        private int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static boolean hasPathSum(Node node, int sum){
        if(node == null){
            return sum == 0;
        }
        return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
    }

    public static void main(String[] args) {
        int sum = 23;

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
        System.out.println("Is one of the sums of path from root to leaf is "+sum+"\t"+hasPathSum(root, sum));
    }

}
