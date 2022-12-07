public class Main {
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any"};

        Trie node = new Trie();
        
        for (String word : words) {
            node.insert(word);
        }

        System.out.println(node.search("an"));
    }
}
