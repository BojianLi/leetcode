public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        permute(result, new ArrayList<Integer>(), new boolean[nums.length], nums);
        return result;
    }
    private void permute(List<List<Integer>> result, List<Integer> array, boolean[] visited, int[] nums) {
        if (array.size() == nums.length) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            array.add(nums[i]);
            permute(result, array, visited, nums);
            array.remove(array.size() - 1);
            visited[i] = false;
        }
    }
}
