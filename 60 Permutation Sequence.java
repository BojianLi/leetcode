public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        for (int i = n - 1; i >= 0; i--) {
            int fac = factorial(i);
            int append = (k - 1) / fac;
            k = k - append * fac;
            int j;
            for (j = 0; j <= append; j++) {
                if (used[j]) {
                    append++;
                }
            }
            used[j - 1] = true;
            sb.append(j);
        }
        return sb.toString();
        
    }
    int factorial (int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }
}
