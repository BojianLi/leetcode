public class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd = nums[0], minEnd = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int a = maxEnd * nums[i];
            int b = minEnd * nums[i];
            maxEnd = Math.max(a, Math.max(b, nums[i]));
            minEnd = Math.min(a, Math.min(b, nums[i]));
            max = Math.max(max, maxEnd);
        }
        return max;
    }
}
