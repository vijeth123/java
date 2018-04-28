package com.vijeth.geeksforgeeks.datastructures.tree;

public class CheckSubTree {

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    private static boolean checkSubTree(Node mainTree, Node subTree){
        //Try to find whether the root-data of subTree is present in mainTree
        if(mainTree.data == subTree.data){
            System.out.println("Intersection point is at: "+mainTree.data);
            System.out.println("Is tree2 a subtree of tree1?: "+ isEqual(mainTree, subTree));
            return true;
        }

        if(mainTree == null){
            return false;
        }
        return checkSubTree(mainTree.left, subTree) || checkSubTree(mainTree.right, subTree);
    }

    private static boolean isEqual(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return (node1.data == node2.data) && isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }


    public static void main(String[] args) {

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30
       */

        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        // TREE 2
     /* Construct the following tree
           10
         /    \
         4      6
          \
          30
     */

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);
        checkSubTree(root1, root2);
    }

}
