public class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < nums.length; i++) {
            c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return c;
    }
}
