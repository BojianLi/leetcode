public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] height = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            height[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= cols; j++) {
                int cur = j == cols ? -1 : height[i][j];
                while (!stack.isEmpty() && cur < height[i][stack.peek()]) {
                    int h = height[i][stack.pop()];
                    int w = j - (stack.isEmpty() ? 0 : stack.peek() + 1);
                    max = Math.max(max, w * h);
                }
                stack.push(j);
            }
        }
        return max;
    }
}
