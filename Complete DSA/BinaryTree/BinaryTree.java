import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private int idx = -1;

    public Node buildTree(int[] nodes) {
        idx++;

        if (nodes[idx] == -1) return null;

        Node root = new Node(nodes[idx]);
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }

    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) q.offer(currentNode.left);
            if (currentNode.right != null) q.offer(currentNode.right);
        }
    }

    public void levelOrderLevelWise(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            if (currentNode == null) {
                if (q.isEmpty()) return;
                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) q.offer(currentNode.left);
            if (currentNode.right != null) q.offer(currentNode.right);
        }
    }

    public void leftView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = q.poll();
                if (i == 0) System.out.print(currentNode.data + " ");

                if (currentNode.left != null) q.offer(currentNode.left);
                if (currentNode.right != null) q.offer(currentNode.right);
            }
        }
    }

    public void rightView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = q.poll();
                if (i == 0) System.out.print(currentNode.data + " ");

                if (currentNode.right != null) q.offer(currentNode.right);
                if (currentNode.left != null) q.offer(currentNode.left);
            }
        }
    }

    public int height(Node root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int countNodes(Node root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int maxNode(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        return Math.max(root.data, Math.max(maxNode(root.left), maxNode(root.right)));
    }

    public int treeSum(Node root) {
        if (root == null) return 0;

        return treeSum(root.left) + treeSum(root.right) + root.data;
    }
}
