public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = n - len; i >= 0; i--) {
                for (int j = n - len; j >= 0; j--) {
                    boolean b = false;
                    for (int k = 1; k < len && !b; k++) {
                        b =  dp[k - 1][i][j] && dp[len - k - 1][i + k][j + k] 
                        || dp[k - 1][i][j + len - k] && dp[len - k - 1][i + k][j];
                    }
                    dp[len - 1][i][j] = b;
                }
            }
        }
        return dp[n - 1][0][0];
    }
}
