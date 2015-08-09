public class Solution {
    private boolean canSurvive(int health, int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = health + dungeon[0][0];
        if (dp[0][0] <= 0) {
            return false;
        }
        for (int i = 1; i < rows; i++) {
            if (dp[i - 1][0] == Integer.MIN_VALUE) {
                dp[i][0] = Integer.MIN_VALUE;
            } else {
                dp[i][0] = dp[i - 1][0] + dungeon[i][0];
                if (dp[i][0] <= 0) {
                    dp[i][0] = Integer.MIN_VALUE;
                }
            }
        }
        for (int j = 1; j < cols; j++) {
            if (dp[0][j - 1] == Integer.MIN_VALUE) {
                dp[0][j] = Integer.MIN_VALUE;
            } else {
                dp[0][j] = dp[0][j - 1] + dungeon[0][j];
                if (dp[0][j] <= 0) {
                    dp[0][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (dp[i][j] != Integer.MIN_VALUE) {
                    dp[i][j] += dungeon[i][j];
                    if (dp[i][j] <= 0) {
                        dp[i][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        return dp[rows - 1][cols - 1] > 0;
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        int start = 1, end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (canSurvive(mid, dungeon)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
