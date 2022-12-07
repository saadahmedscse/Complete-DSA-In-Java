public class Trie {
    class Node {
        Node[] children;
        boolean isEnd;

        private Node root = new Node();

        public Node() {
            children = new Node[26]; // for lowercase 'a' to 'z'
            
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

            isEnd = false;
        }

        public void insert(String word) {
            Node currentNode = root;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (currentNode.children[idx] == null) {
                    currentNode.children[idx] = new Node();
                }
                currentNode = currentNode.children[idx];
            }
        }
    }
}