public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int bucketGap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int i : nums) {
            if (i == min || i == max) {
                continue;
            }
            int id = (i - min) / bucketGap;
            bucketMin[id] = Math.min(bucketMin[id], i);
            bucketMax[id] = Math.max(bucketMax[id], i);
        }
        int maxGap = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}
