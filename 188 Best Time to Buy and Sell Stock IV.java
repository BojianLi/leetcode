public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }
        int[][] profit = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int buy = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], buy + prices[j]);
                buy = Math.max(buy, profit[i - 1][j] - prices[j]);
            }
        }
        return profit[k][prices.length - 1];
        
        
    }
    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
