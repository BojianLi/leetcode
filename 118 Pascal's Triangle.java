public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> oldList = list;
            list = new ArrayList<Integer>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(oldList.get(j) + oldList.get(j - 1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
