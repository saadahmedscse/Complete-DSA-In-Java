package BinaryTree.BinaryTree;

public class BinaryTree {

    /**
     * Binary Tree Implemented
     * Author: Saad Ahmed
     * Date: 25 Jan, 2023
     * All functions work in O(N) Time Complexity
     */

    private int iterator = -1;

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node buildTree(int[] array) {
        iterator++;

        if (array[iterator] == -1) return null;

        Node root = new Node(array[iterator]);
        root.left = buildTree(array);
        root.right = buildTree(array);

        return root;
    }

    public void preOrderTraverse(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public void inOrderTraverse(Node root) {
        if (root == null) return;

        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }

    public void postOrderTraverse(Node root) {
        if (root == null) return;

        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data + " ");
    }
}