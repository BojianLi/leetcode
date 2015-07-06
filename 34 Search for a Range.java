public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeft(nums, target, 0, nums.length - 1);
        result[1] = findRight(nums, target, 0, nums.length - 1);
        return result;
    }
    private int findLeft(int[] nums, int target, int start, int end) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (end - start) / 2 + start;
        if (nums[mid] < target) return findLeft(nums, target, mid + 1, end);
        else return findLeft(nums, target, start, mid);
    }
    private int findRight(int[] nums, int target, int start, int end) {
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = (end - start + 1) / 2 + start;
        if (nums[mid] <= target) return findRight(nums, target, mid, end);
        else return findRight(nums, target, start, mid - 1);
    }
}
