public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int[] divisor = {5, 3, 2};
        for (int d : divisor) {
            while (num % d == 0) {
                num /= d;
            }
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }
}
