public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        int result = 0;
        boolean neg = dividend > 0 ^ divisor >0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        if (neg) {
            result = -result;
        }
        return result;
    }
}
