public class Solution {
    private int[][] mat;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        mat = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                mat[i][j] = -1;
        return dfs(m - 1, n - 1, obstacleGrid);
    }
    private int dfs(int i, int j, int[][] obstacleGrid) {
        if(i < 0 || j < 0) return 0;
        if(obstacleGrid[i][j] == 1) {
            return 0;
        }
        if(i == 0 && j == 0) return 1;
        if(i != 0 && mat[i - 1][j] == -1) {
            mat[i - 1][j] = dfs(i - 1, j, obstacleGrid);
        }
        if(j != 0 && mat[i][j - 1] == -1) {
            mat[i][j - 1] = dfs(i, j - 1, obstacleGrid);
        }
        if(i == 0) {
            return mat[i][j - 1];
        } else if(j == 0) {
            return mat[i - 1][j];
        }
        return mat[i - 1][j] + mat[i][j - 1];
    }
}
