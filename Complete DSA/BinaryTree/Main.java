public class Main {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, -1, -1, 4, 9, -1, -1, -1, 5, 6, -1, -1, 7, -1, -1};

        //             1
        //         2       5
        //     3     4  6     7
        //         9

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        //tree.preOrder(root);                          // 1 2 3 4 9 5 6 7
        //tree.inOrder(root);                           // 3 2 9 4 1 6 5 7
        //tree.postOrder(root);                         // 3 9 4 2 6 7 5 1
        //System.out.println(tree.height(root));        // 4
        //System.out.println(tree.countNodes(root));    // 8
        //System.out.println(tree.maxNode(root));       // 9
        //System.out.println(tree.treeSum(root));       // 38
        //tree.levelOrder(root);                        // 1 2 5 3 4 6 7 9
        //tree.levelOrderLevelWise(root);               // 1 -> 2 3 -> 3 4 6 7 -> 9
        //tree.leftView(root);                          // 1 2 3 9
        //tree.rightView(root);                         // 1 5 7 9
        //tree.topView(root);                           // 3 2 1 5 7
        //tree.bottomView(root);                        // 3 9 6 5 7
        //System.out.println(tree.maxDiameter(root));   // 6 Diameter = {6 -> 4 -> 2 -> 1 -> 5 -> 7}
    }
}
