public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r && nums[l] >= nums[r]) {
            int m = (l + r) / 2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else if(nums[m] > nums[l]) {
                r = m;
            } else {
                l = l + 1;
            }
        }
        return nums[l];
    }
}
