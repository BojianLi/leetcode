public class Solution {
    public void sortColors(int[] nums) {
        int[] counting = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counting[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (counting[j] == 0) {
                j++;
            }
            counting[j]--;
            nums[i] = j;
        }
    }
}





public class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                i++;
                l++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
