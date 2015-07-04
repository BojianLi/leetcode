public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum2(candidates, target, 0, 0, result, new ArrayList<Integer>());
        return result;
    }
    private void combinationSum2(int[] candidates, int target, int index, int sum, 
    List<List<Integer>> result, List<Integer> array) {
        int pre = -1;
        for (int i = index; i < candidates.length; i++) {
            if (pre == candidates[i]) continue;
            pre = candidates[i];
            if (sum + candidates[i] > target) return;
            if (sum + candidates[i] == target) {
                array.add(candidates[i]);
                result.add(new ArrayList(array));
                array.remove(array.size() - 1);
            }
            array.add(candidates[i]);
            combinationSum2(candidates, target, i + 1, sum + candidates[i], result, array);
            array.remove(array.size() - 1);
        }
    }
}
