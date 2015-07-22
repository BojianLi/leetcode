public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        return search(matrix, target, 0, 0, m - 1, n - 1);
    }
    private boolean search(int[][] matrix, int target, int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2) {
            return false;
        }
        int rmid = row1 + (row2 - row1) / 2;
        int cmid = col1 + (col2 - col1) / 2;
        if (target == matrix[rmid][cmid]) {
            return true;
        } else if (target < matrix[rmid][cmid]) {
            return search(matrix, target, row1, col1, rmid - 1, col2) || search(matrix, target, rmid, col1, row2, cmid - 1);
        } else {
            return search(matrix, target, rmid + 1, col1, row2, col2) || search(matrix, target, row1, cmid + 1, rmid, col2);
        }
    }
}
