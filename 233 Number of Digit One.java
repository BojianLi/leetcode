public class Solution {
    public int countDigitOne(int n) {
        long sum = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            long s = 0;
            s = a / 10;
            if (a % 10 >= 1) {
                s++;
            }
            s *= m;
            if (a % 10 == 1) {
                s -= m - b - 1;
            }
            sum += s;
        }
        return (int)sum;
    }
}
