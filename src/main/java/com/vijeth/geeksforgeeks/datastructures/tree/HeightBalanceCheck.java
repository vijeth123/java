package com.vijeth.geeksforgeeks.datastructures.tree;

public class HeightBalanceCheck {

    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    private static int height(Node node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static boolean isBalanced(Node node){
        if(node == null){
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if((Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(node.left) && isBalanced(node.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7
     */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        //root.left.left.left.left = new Node(8);

        System.out.println("Height of this tree is: "+ height(root));
        System.out.println("Is this tree height balanced? "+ isBalanced(root));
    }

}
