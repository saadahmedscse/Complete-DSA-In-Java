package BinaryTree.BinarySearchTree;

public class BinaryTree {

    /**
     * Binary Search Tree Implemented
     * Author: Saad Ahmed
     * Date: 25 Jan, 2023
     */

    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Time Complexity [insertUsingLoop()] function:
     * Best Case O(LogN)
     * Average Case O(LogN)
     * Worst Case O(N)
     */

    public void insertUsingLoop(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node prevNode = null;
        Node currentNode = root;

        while (currentNode != null) {

            prevNode = currentNode;

            if (currentNode.data > data) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }

        if (prevNode.data > data) prevNode.left = newNode;
        else prevNode.right = newNode;
    }

    /**
     * Time Complexity [insertUsingLoop()] function:
     * Best Case O(LogN)
     * Average Case O(LogN)
     * Worst Case O(N)
     */

    public boolean searchUsingLoop(Node root, int data) {
        while (root != null) {
            if (root.data == data) return true;

            if (root.data > data) root = root.left;
            else if (root.data < data) root = root.right;
        }

        return false;
    }

    /**
     * Time Complexity [insertUsingRecursion()] function:
     * Best Case O(LogN)
     * Average Case O(LogN)
     * Worst Case O(N)
     */

    public void insertUsingRecursion(int data) {
        root = insertUsingRecursion(root, data);
    }

    private Node insertUsingRecursion(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.data > data) root.left = insertUsingRecursion(root.left, data);
        else if (root.data < data) root.right = insertUsingRecursion(root.right, data);

        return root;
    }

    /**
     * Time Complexity [searchUsingRecursion()] function:
     * Best Case O(LogN)
     * Average Case O(LogN)
     * Worst Case O(N)
     */

    public boolean searchUsingRecursion(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;

        if (root.data > data) return searchUsingRecursion(root.left, data);

        return searchUsingRecursion(root.right, data);
    }
    
    /**
     * Time Complexity [inOrderTraverse()] function:
     * O(N)
     */

    public void inOrderTraverse(Node root) {
        if (root == null) return;

        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }

    public Node getRoot() {
        return root;
    }
}