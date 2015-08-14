class TrieNode {
    String val;
    TrieNode[] next;
    public TrieNode() {
        val = null;
        next = new TrieNode[26];
    }
}

public class Solution {
    TrieNode root;
    boolean[][] visited;
    char[][] board;
    Set<String> set;
    private void insert(String word) {
        if (word == null | word.length() == 0) {
            return;
        }
        root = insert(root, word, 0);
    }
    private TrieNode insert(TrieNode node, String word, int i) {
        if (node == null) {
            node = new TrieNode();
        }
        if (i == word.length()) {
            node.val = word;
        } else {
            node.next[word.charAt(i) - 'a'] = insert(node.next[word.charAt(i) - 'a'], word, i + 1);
        }
        return node;
    }
    public List<String> findWords(char[][] board, String[] words) {
        set = new HashSet<String>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<String>();
        }
        this.board = board;
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                search(root, i, j);
            }
        }
        List<String> result = new ArrayList<String>(set);
        return result;
    }
    private void search(TrieNode node, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        int next = board[i][j] - 'a';
        TrieNode nextNode = node.next[next];
        if (nextNode == null) {
            return;
        }
        if (nextNode.val != null) {
            set.add(node.next[next].val);
        }
        visited[i][j] = true;
        search(nextNode, i - 1, j);
        search(nextNode, i + 1, j);
        search(nextNode, i, j + 1);
        search(nextNode, i, j - 1);
        visited[i][j] = false;
        
    }
}
