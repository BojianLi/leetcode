public class Solution {
    boolean cycle = false;
    boolean[] marked;
    boolean[] onStack;
    boolean[][] matrix;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        matrix = new boolean[numCourses][numCourses];
        for (int[] pair : prerequisites) {
            int pre = pair[1];
            int post = pair[0];
            matrix[pre][post] = true;
        }
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (cycle) {
                return false;
            }
            dfs(i);
        }
        return true;
    }
    private void dfs(int i) {
        if (cycle) {
            return;
        }
        if (onStack[i]) {
            cycle = true;
            return;
        }
        if (marked[i]) {
            return;
        }
        marked[i] = true;
        onStack[i] = true;
        for (int j = 0; j < onStack.length; j++) {
            if (matrix[i][j]) {
                dfs(j);
            }
        }
        onStack[i] = false;
    }
}
