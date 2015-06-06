public class Solution {
    public int maxSubArray(int[] nums) {
        int maxEnd = nums[0], maxSF = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            maxSF = Math.max(maxEnd, maxSF);
        }
        return maxSF;
    }
}
