public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int n = matrix.length;
        if(n == 0) return list;
        int m = matrix[0].length;
        int i = 0;
        int j = -1;
        while(true) {
            if(m == 0) break;
            for(int iter = 0; iter < m; iter++) {
                list.add(matrix[i][++j]);
            }
            if(--n == 0) break;
            for(int iter = 0; iter < n; iter++) {
                list.add(matrix[++i][j]);
            }
            if(--m == 0) break;
            for(int iter = 0; iter < m; iter++) {
                list.add(matrix[i][--j]);
            }
            
            if(--n == 0) break;
            for(int iter = 0; iter < n; iter++) {
                list.add(matrix[--i][j]);
            }
            if(--m == 0) break;
        }
        return list;
    }
}
