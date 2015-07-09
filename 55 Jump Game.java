public class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int i = 0;
        while (i <= farthest) {
            int jump = nums[i] + i;
            i++;
            if (jump >= nums.length - 1) {
                return true;
            }
            if (jump > farthest) {
                farthest = jump;
            }
        }
        return false;
    }
}
