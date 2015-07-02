//dummy method

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        int max = c;
        a = 0; b = 0; c = 0;
        for (int i = 1; i < nums.length; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        if (c > max) max = c;
        return max;
    }
}
