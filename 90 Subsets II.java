public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsets(result, array, nums, 0);
        return result;
    }
    private void subsets(List<List<Integer>> result, List<Integer> array, int[] nums, int index) {
        result.add(new ArrayList<Integer>(array));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            array.add(nums[i]);
            subsets(result, array, nums, i + 1);
            array.remove(array.size() - 1);
        }
    }
}
