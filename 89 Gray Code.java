public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> arr;
        if (n == 0) {
            arr = new ArrayList<Integer>();
            arr.add(0);
            return arr;
        }
        arr = grayCode(n - 1);
        int length = arr.size();
        for (int i = length - 1; i >=0; i--) {
            arr.add(arr.get(i) + (1 << (n - 1)));
        }
        return arr;
    }
}
