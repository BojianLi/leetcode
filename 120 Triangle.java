public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] min = new int[triangle.size()];
        min[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            min[i] = min[i - 1] + list.get(i);
            for (int j = i - 1; j >= 1; j--) {
                min[j] = Math.min(min[j], min[j - 1]) + list.get(j);
            }
            min[0] += list.get(0);
        }
        int m = min[0];
        for (int i = 1; i < min.length; i++) {
            m = min[i] < m ? min[i] : m;
        }
        return m;
    }
}
