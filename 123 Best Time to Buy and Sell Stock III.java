public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int l = prices.length;
        int[] left = new int[l];
        int[] right = new int[l];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < l; i++) {
            if (prices[i] < min) {
                min = prices[i];
                left[i] = left[i - 1];
            } else if (prices[i] - min > left[i - 1]){
                left[i] = prices[i] - min;
            } else {
                left[i] = left[i - 1];
            }
        }
        right[l - 1] = 0;
        int max = prices[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
                right[i] = right[i + 1];
            } else if (max - prices[i] > right[i + 1]) {
                right[i] = max - prices[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < l; i++) {
            if (left[i] + right[i] > maxProfit) {
                maxProfit = left[i] + right[i];
            }
        }
        return maxProfit;
    }
}
