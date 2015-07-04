public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0) return result;
        combinationSum3(result, new ArrayList<Integer>(), k, n, 1, 0);
        return result;
    }
    private void combinationSum3(List<List<Integer>> result, List<Integer> array, int k, int n, int index, int sum) {
        if (sum == n && k == 0) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        if (sum > n || k == 0) {
            return;
        }
        for (int i = index; i < 10; i++) {
            array.add(i);
            combinationSum3(result, array, k - 1, n, i + 1, sum + i);
            array.remove(array.size() - 1);
        }
    }
}
