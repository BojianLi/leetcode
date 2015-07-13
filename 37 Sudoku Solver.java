public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = (char)(k + '0');
                        if (isValid(board, i, j) && solve(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int a, int b) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            if (board[i][b] == '.') {
                continue;
            }
            if (!set.contains(board[i][b])) {
                set.add(board[i][b]);
            } else {
                return false;
            }
        }
        set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            if (board[a][i] == '.') {
                continue;
            }
            if (!set.contains(board[a][i])) {
                set.add(board[a][i]);
            } else {
                return false;
            }
        }
        set = new HashSet<Character>();
        for (int i = a / 3 * 3; i < 3 + a / 3 * 3; i++) {
            for (int j = b / 3 * 3; j < b / 3 * 3 + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                } else {
                    return false;
            }
            }
        }
        return true;
    }
}
