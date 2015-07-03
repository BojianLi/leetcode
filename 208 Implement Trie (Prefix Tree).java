class TrieNode {
    // Initialize your data structure here.
    boolean val;
    TrieNode[] next;
    public TrieNode() {
        val = false;
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);
    }
    private TrieNode insert(TrieNode node, String word, int d) {
        if (node == null) node = new TrieNode();
        if (d == word.length()) {
            node.val = true;
            return node;
        }
        node.next[word.charAt(d) - 'a'] = insert(node.next[word.charAt(d) - 'a'], word, d + 1);
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode node, String word, int d) {
        if (node == null) return false;
        if (d == word.length()) return node.val;
        return search(node.next[word.charAt(d) - 'a'], word, d + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }
    private boolean startsWith(TrieNode node, String prefix, int d) {
        if (node == null) return false;
        if (d == prefix.length()) {
            return find(node);
        }
        return startsWith(node.next[prefix.charAt(d) - 'a'], prefix, d + 1);
    }
    private boolean find(TrieNode node) {
        if (node == null) return false;
        if (node.val) return true;
        for (int i = 0; i < 26; i++) {
            if (find(node.next[i])) {
                return true;
            }
        }
        return false;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
