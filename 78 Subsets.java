public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> array = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsets(result, array, nums, 0);
        return result;
    }
    private void subsets(List<List<Integer>> result, List<Integer> array, int[] nums, int index) {
        result.add(new ArrayList<Integer>(array));
        for (int i = index; i < nums.length; i++) {
            array.add(nums[i]);
            subsets(result, array, nums, i + 1);
            array.remove(array.size() - 1);
        }
    }
}
