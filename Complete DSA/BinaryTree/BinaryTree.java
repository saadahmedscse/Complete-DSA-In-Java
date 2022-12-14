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

    static class VerticalPair {
        int horizontalDirection;
        LinkedList<Node> list;

        public VerticalPair(int horizontalDirection, LinkedList<Node> list) {
            this.horizontalDirection = horizontalDirection;
            this.list = list;
        }
    }

    public void verticalOrder(Node root) {
        if (root == null) return;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Node>> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            if (!map.containsKey(pair.horizontalDirection)) {
                ArrayList<Node> list = new ArrayList<>();
                map.put(pair.horizontalDirection, list);
            }
            map.get(pair.horizontalDirection).add(pair.node);

            if (pair.node.left != null) {
                q.add(new Pair(pair.horizontalDirection - 1, pair.node.left));
            }

            if (pair.node.right != null) {
                q.add(new Pair(pair.horizontalDirection + 1, pair.node.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Node>> me : map.entrySet()) {
            for (Node n : me.getValue()) {
                System.out.print(n.data + " ");
            }
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

    public void floorAndCeil(Node root, int key) { // Time Complexity O(logN) Space Complexity O(1)
        if (root == null) return;

        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        while (root != null) {
            if (key < root.data) {
                ceil = Math.min(ceil, root.data);
                root = root.left;
            } else {
                floor = Math.max(floor, root.data);
                root = root.right;
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);
    }

    public void floorAndCeilArrayList(Node root, int key) {
        if (root == null) return;

        List<Integer> res = new ArrayList<>();
        pFACA(root, res);

        int floor = res.get(0);
        int ceil = res.get(res.size() - 1);

        //Searching Floor and Ceil with O(n) time complexity
//        for (int i = res.size() - 1; i >= 0; i--) {
//            if (res.get(i) < key) {
//                floor = Math.max(floor, res.get(i));
//            }
//            if (res.get(i) > key) {
//                ceil = Math.min(ceil, res.get(i));
//            }
//        }

        //Searching Floor and Ceil with O(logN) time complexity
        int s = 0, e = res.size() - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int midVal = res.get(mid);

            if (midVal > key) {
                e = mid - 1;
                ceil = Math.min(ceil, midVal);
            }
            else {
                s = mid + 1;
                floor = Math.max(floor, midVal);
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);
    }

    private void pFACA(Node root, List<Integer> list) {
        if (root == null) return;

        pFACA(root.left, list);
        list.add(root.data);
        pFACA(root.right, list);
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

    public Node lowestCommonAncestor(Node root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) return root;

        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    Node prev = null;
    Node head = null;
    public void flattenInOrder(Node root) {
        binaryTreeToFlattenDoublyLinkedListInOrder(root);

        while (head != null) {
            System.out.print(head.data + " <-> ");
            head = head.right;
        }

        System.out.print("null");
    }

    private void binaryTreeToFlattenDoublyLinkedListInOrder(Node root) {
        if (root == null) return;

        binaryTreeToFlattenDoublyLinkedListInOrder(root.left);

        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        binaryTreeToFlattenDoublyLinkedListInOrder(root.right);
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
