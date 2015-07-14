public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        combine(result, array, n, k, 1);
        return result;
    }
    private void combine(List<List<Integer>> result, List<Integer> array, int n, int k, int ii) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        for (int i = ii; i <= n; i++) {
            array.add(i);
            combine(result, array, n, k - 1, i + 1);
            array.remove(array.size() - 1);
        }
    }
}
