public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int m = (end - start) / 2 + start;
            if (nums[m] == target) {
                return true;
            }
            if (nums[start] > nums[m]) {
                if (nums[m] < target && target <= nums[end]) {
                    start = m + 1;
                } else {
                    end = m - 1;
                }
            } else if (nums[start] < nums[m]){
                if (nums[m] > target && target >= nums[start]) {
                    end = m - 1;
                } else {
                    start = m + 1;
                }
            } else {
                start++;
            }
        }
        if (nums[start] == target) {
            return true;
        } else if (nums[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
