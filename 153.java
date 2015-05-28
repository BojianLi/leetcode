public class Solution {
    public int findMin(int[] nums) {
        int t = nums[0];
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] < t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if(nums[l] < t) {
            return nums[l];
        } else {
            return nums[0];
        }
    }
}
