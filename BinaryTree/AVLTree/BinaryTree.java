package BinaryTree.AVLTree;

public class BinaryTree {

    /**
     * Custom AVL Binary Tree implemented
     * Author: Saad Ahmed
     * Date: 29 Jan, 2023
     */

    public Node root;

    public static class Node {
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    /**
     * Time Complexity [insert()] function:
     * O(LogN)
     */

    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        else return root;

        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && data < root.left.data) return rightRotate(root);
        if (balance < -1 && data > root.right.data) return leftRotate(root);
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node rightRotate(Node x) {
        Node y = x.left;
        Node z = y.right;

        y.right = x;
        x.left = z;

        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        x.height = 1 + (max(height(x.left), height(x.right)));
        y.height = 1 + (max(height(y.left), height(y.right)));

        return y;
    }

    private int max(int x, int y) {
        return Math.max(x, y);
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    /**
     * Time Complexity [search()] function:
     * O(LogN)
     */

    public Node search(Node root, int data) {
        if (root == null) return null;

        if (data < root.data) return search(root.left, data);
        if (data > root.data) return search(root.right, data);

        return root;
    }

    public void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}