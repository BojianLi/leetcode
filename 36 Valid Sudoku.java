public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[] taken = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(taken, false);
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (taken[num]) return false;
                taken[num] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(taken, false);
            for (int j = 0; j < n; j++) {
                if (board[j][i] == '.') continue;
                int num = board[j][i] - '1';
                if (taken[num]) return false;
                taken[num] = true;
            }
        }
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Arrays.fill(taken, false);
                for (int k = 0; k < 9; k++) {
                    if (board[i + k / 3][j + k % 3] == '.') continue;
                    int num = board[i + k / 3][j + k % 3] - '1';
                    if (taken[num]) return false;
                    taken[num] = true;
                }
            }
        }
        return true;
    }
}
