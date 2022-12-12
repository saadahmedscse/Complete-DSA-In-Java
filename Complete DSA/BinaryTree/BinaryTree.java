import java.util.*;

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

    static class Pair {
        int horizontalDirection;
        Node node;

        public Pair(int horizontalDirection, Node node) {
            this.horizontalDirection = horizontalDirection;
            this.node = node;
        }
    }

    public void topView(Node root) {
        if (root == null) return;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>(); //Using TreeMap for ascending order

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair currentPair = q.poll();

            if (!map.containsKey(currentPair.horizontalDirection)) {
                map.put(currentPair.horizontalDirection, currentPair.node.data);
            }

            if (currentPair.node.left != null) {
                q.add(new Pair(currentPair.horizontalDirection - 1, currentPair.node.left));
            }

            if (currentPair.node.right != null) {
                q.add(new Pair(currentPair.horizontalDirection + 1, currentPair.node.right));
            }
        }

        for (int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }

    public void bottomView(Node root) {
        if (root == null) return;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair currentPair = q.poll();

            map.put(currentPair.horizontalDirection, currentPair.node.data);

            if (currentPair.node.left != null) {
                q.add(new Pair(currentPair.horizontalDirection - 1, currentPair.node.left));
            }

            if (currentPair.node.right != null) {
                q.add(new Pair(currentPair.horizontalDirection + 1, currentPair.node.right));
            }
        }

        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            System.out.print(me.getValue() + " ");
        }
    }

    public int height(Node root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private int maxDiam = Integer.MIN_VALUE;
    public int maxDiameter(Node root) {
        if (root == null) return 0;

        calculateMaxDiameter(root);

        return maxDiam;
    }

    private int calculateMaxDiameter(Node root) {
        if (root == null) return 0;

        int leftDiam = calculateMaxDiameter(root.left);
        int rightDiam = calculateMaxDiameter(root.right);

        maxDiam = Math.max(maxDiam, leftDiam + rightDiam + 1);

        return Math.max(leftDiam, rightDiam) + 1;
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
