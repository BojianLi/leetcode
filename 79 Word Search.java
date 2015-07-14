public class Solution {
    private Set<Integer> set = new HashSet<Integer>();
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    set.add(i * n + j);
                    if (exist(board, word, 1, i, j)) {
                        return true;
                    }
                    set.remove(i * n + j);
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, String word, int index, int px, int py) {
        if (index == word.length()) {
            return true;
        }
        if (px - 1 >= 0 && !set.contains((px - 1) * n + py)) {
            if (word.charAt(index) == board[px - 1][py]) {
                set.add((px - 1) * n + py);
                if (exist(board, word, index + 1, px - 1, py)) {
                    return true;
                }
                set.remove((px - 1) * n + py);
            }
        }
        if (px + 1 < m && !set.contains((px + 1) * n + py)) {
            if (word.charAt(index) == board[px + 1][py]) {
                set.add((px + 1) * n + py);
                if (exist(board, word, index + 1, px + 1, py)) {
                    return true;
                }
                set.remove((px + 1) * n + py);
            }
        }
        if (py - 1 >= 0 && !set.contains(px * n + py - 1)) {
            if (word.charAt(index) == board[px][py - 1]) {
                set.add(px * n + py - 1);
                if (exist(board, word, index + 1, px, py - 1)) {
                    return true;
                }
                set.remove(px * n + py - 1);
            }
        }
        if (py + 1 < n && !set.contains(px * n + py + 1)) {
            if (word.charAt(index) == board[px][py + 1]) {
                set.add(px * n + py + 1);
                if (exist(board, word, index + 1, px, py + 1)) {
                    return true;
                }
                set.remove(px * n + py + 1);
            }
        }
        return false;
    }
}
