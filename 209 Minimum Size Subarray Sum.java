public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] >= s) {
            return 1;
        }
        int length = Integer.MAX_VALUE;
        int subsum = nums[0];
        int start = 0;
        int end = 0;
        while (true) {
            if (subsum < s) {
                end++;
                if (end == nums.length) {
                    break;
                }
                subsum += nums[end];
            } else {
                length = Math.min(length, end - start + 1);
                if (length == 1) {
                    break;
                }
                subsum -= nums[start];
                start++;
            }
        }
        if (length == Integer.MAX_VALUE) {
            return 0;
        } else {
            return length;
        }
    }
}
