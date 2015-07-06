public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Math.abs(target - (nums[0] + nums[1] + nums[2]));
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int d = Math.abs(sum - target);
                if (d < diff) {
                    result = sum;
                    diff = d;
                }
                if (sum - target > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1])  right--;
                } else if (sum - target < 0) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    return target;
                }
                
            }
        }
        return result;
    }
}
