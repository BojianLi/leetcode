public class Solution {
    private int[][] mat;
    public int uniquePaths(int m, int n) {
        mat = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                mat[i][j] = -1;
        return dfs(m - 1, n - 1);
    }
    private int dfs(int i, int j) {
        if(i < 0 || j < 0) return 0;
        if(i == 0 || j == 0) return 1;
        if(mat[i - 1][j] == -1) {
            mat[i - 1][j] = dfs(i - 1, j);
        }
        if(mat[i][j - 1] == -1) {
            mat[i][j - 1] = dfs(i, j - 1);
        }
        return mat[i - 1][j] + mat[i][j - 1];
    }
}
