public class WordBreak {
     public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "catsandog";

        String[] dict1 = {"leet", "code"};
        String[] dict2 = {"cats", "dog", "sand", "and", "cat"};

        System.out.println(wordBreak(s2, dict2));
     }

     //LeetCode - 139. Word Break
      public static boolean wordBreak(String s, String[] dict) {
         Trie trie = new Trie();

         for (String word : dict) {
            trie.insert(word);
         }

         return divide(s, trie);
      }

      public static boolean divide(String s, Trie trie) {
         if (s.length() == 0) return true;

         for (int i = 1; i <= s.length(); i++) {
            String prev = s.substring(0, i);
            String rest = s.substring(i);

            if (trie.search(prev) && divide(rest, trie)) return true;
         }

         return false;
      }
}
