public class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int count = 0;
        while (count * 2 < n) {
            for (int i = count; i < n - count; i++) {
                matrix[count][i] = num++;
            }
            for (int i = count + 1; i < n - count; i++) {
                matrix[i][n - count - 1] = num++;
            }
            for (int i = n - count - 2; i >= count; i--) {
                matrix[n - count - 1][i] = num++;
            }
            for (int i = n - count - 2; i > count; i--) {
                matrix[i][count] = num++;
            }
            count++;
        }
        return matrix;
    }
}
