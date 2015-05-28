public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        return bSearch(nums, 0, len - 1, target);
    }
    int bSearch(int[] nums, int l, int r, int target) {
        if (l == r) {
            if (nums[l] >= target) {
                return l;
            } else {
                return l + 1;
            }
        }
        int m = (r - l) / 2 + l;
        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            return bSearch(nums, m + 1, r, target);
        } else {
            return bSearch(nums, l, m, target);
        }
    }
}
