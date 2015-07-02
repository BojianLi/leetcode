public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n <= 0) {
            return result;
        }
        result = search(n, result, new int[n], 0);
        return result;
    }
    
    private List<List<String>> search(int n, List<List<String>> result, int[] position, int index) {
        if (invalid(position, index)) {
            return result;
        }
        if (index == n) {
            result.add(fromP(position));
            return result;
        }
        for (int i = 0; i < n; i++) {
            position[index] = i;
            result = search(n, result, position, index + 1);
        }
        return result;
    }
    private boolean invalid(int[] position, int index) {
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (position[i] == position[j] || Math.abs(position[i] - position[j]) == j - i) {
                    return true;
                }
            }
        }
        return false;
    }
    private List<String> fromP(int[] position) {
        List<String> arr = new ArrayList<String>();
        int n = position.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == position[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            arr.add(sb.toString());
        }
        return arr;
    }
}
