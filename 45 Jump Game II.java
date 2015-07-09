public class Solution {
    public int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int farthest = 0;
        int jump = 0;
        while (start <= end) {
            if (end >= nums.length - 1) {
                return jump;
            }
            jump++;
            for (int i = start; i <= end; i++) {
                int range = nums[i] + i;
                if (range > farthest) {
                    farthest = range;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return -1;
    }
}
