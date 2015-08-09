public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'T';
                q.offer(i * cols);
            }
            if (board[i][cols - 1] == 'O') {
                board[i][cols - 1] = 'T';
                q.offer((i + 1) * cols - 1);
            }
        }
        for (int j = 1; j < cols - 1; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'T';
                q.offer(j);
            }
            if (board[rows - 1][j] == 'O') {
                board[rows - 1][j] = 'T';
                q.offer((rows - 1) * cols + j);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            int i = cur / cols;
            int j = cur % cols;
            board[i][j] = 'F';
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = 'T';
                q.offer((i - 1) * cols + j);
            }
            if (i + 1 < rows && board[i + 1][j] == 'O') {
                board[i + 1][j] = 'T';
                q.offer((i + 1) * cols + j);
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = 'T';
                q.offer(i * cols + j - 1);
            }
            if (j + 1 < cols && board[i][j + 1] == 'O') {
                board[i][j + 1] = 'T';
                q.offer(i * cols + j + 1);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
}
