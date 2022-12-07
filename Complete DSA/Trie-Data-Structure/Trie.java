public class Trie {
    
    private Node root = new Node();

    private class Node {

        Node[] children;
        boolean isEnd;
    
        public Node() {
            children = new Node[26]; // for lowercase 'a' to 'z'
            
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
    
            isEnd = false;
        }
    }

    public void insert(String word) { //Time Complexity O(L) "where 'L' is the length of a word"
        Node currentNode = root;
    
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (currentNode.children[idx] == null) {
                currentNode.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                currentNode.children[idx].isEnd = true;
            }

            currentNode = currentNode.children[idx];
        }
    }

    public boolean search(String word) { //Time Complexity O(L) "where 'L' is the length of a word"
        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (currentNode.children[idx] == null) return false;
            if (i == word.length() - 1 && !currentNode.children[idx].isEnd) return false;

            currentNode = currentNode.children[idx];
        }

        return true;
    }
}
