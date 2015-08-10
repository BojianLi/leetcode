public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                dp[i][i + len] = dp[i + 1][i + len - 1] && s.charAt(i) == s.charAt(i + len);
            }
        }
        int[] re = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            re[i] = i - 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j][i - 1]) {
                    re[i] = Math.min(re[j] + 1, re[i]);
                }
            }
        }
        return re[n];
    }
}
