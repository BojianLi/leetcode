public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        boolean twice = false;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j++];
                twice = false;
            } else if (twice){
                j++;
            } else {
                nums[++i] = nums[j++];
                twice = true;
            }
        }
        return i + 1;
    }
}
