package Trie;

public class Trie {

    /**
     * Trie Data Structure Implemented
     * Author: Saad Ahmed
     * Date: 25 Jan, 2023
     */

    Node root = new Node();

    private class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }

        public void makeEnd() {
            this.isEnd = true;
        }
    }

    /**
     * Time Complexity [insert()] function:
     * O(avgL)
     */

    public void insert(String word) {
        Node pointer = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (pointer.children[idx] == null) {
                pointer.children[idx] = new Node();
            }

            pointer = pointer.children[idx];
        }

        pointer.makeEnd();
    }

    /**
     * Time Complexity [insertWordArray()] function:
     * O(N * avgL)
     */

    public void insertWordArray(String[] words) {
        for (String s : words) {
            Node pointer = root;

            for (char c : s.toCharArray()) {
                int idx = c - 'a';

                if (pointer.children[idx] == null) {
                    pointer.children[idx] = new Node();
                }

                pointer = pointer.children[idx];
            }

            pointer.makeEnd();
        }
    }

    /**
     * Time Complexity [search()] function:
     * O(L)
     */

    public boolean search(String word) {
        Node pointer = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (pointer.children[idx] == null) return false;
            pointer = pointer.children[idx];

            if (pointer.isEnd && i == word.length() - 1) return true;
        }

        return false;
    }

    /**
     * Time Complexity [startsWith()] function:
     * O(L)
     */

    public boolean startsWith(String prefix) {
        Node pointer = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if (pointer.children[idx] == null) return false;

            pointer = pointer.children[idx];
        }

        return true;
    }
}