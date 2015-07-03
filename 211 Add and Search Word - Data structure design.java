public class WordDictionary {
    private TrieNode root = new TrieNode();
    private static class TrieNode {
        boolean val = false;
        TrieNode[] next = new TrieNode[26];
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        int d = 0;
        while (d != word.length()) {
            if (node.next[word.charAt(d) - 'a'] == null) {
                node.next[word.charAt(d) - 'a'] = new TrieNode();
            }
            node = node.next[word.charAt(d) - 'a'];
            d++;
        }
        node.val = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode node, String word, int d) {
        if (node == null) return false;
        if (d == word.length()) return node.val;
        char c = word.charAt(d);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(node.next[i], word, d + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(node.next[c - 'a'], word, d + 1);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
