public class Solution {
    private boolean[][] travelled;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        travelled = new boolean[rows][cols];
        int num = 0;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!travelled[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid);
                    num++;
                }
            }
        }
        return num;
    }
    private void bfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= travelled.length || j < 0 || j >= travelled[0].length) {
            return;
        }
        if (travelled[i][j] || grid[i][j] == '0') {
            return;
        }
        travelled[i][j] = true;
        bfs(i + 1, j, grid);
        bfs(i - 1, j, grid);
        bfs(i, j - 1, grid);
        bfs(i, j + 1, grid);
    }
}
