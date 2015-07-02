public class Solution {
    public int totalNQueens(int n) {
        int result = 0;
        if (n <= 0) {
            return result;
        }
        result = search(n, result, new int[n], 0);
        return result;
    }
    
    private int search(int n, int result, int[] position, int index) {
        if (invalid(position, index)) {
            return result;
        }
        if (index == n) {
            result++;
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
}

