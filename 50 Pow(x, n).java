public class Solution {
    public double myPow(double x, int n) {
        boolean min = false;
        if (n < 0) {
            min = true;
            n = -n;
        }
        double result = 1;
        result = pow(x, n);
        return min ? 1/result : result;
    }
    private double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return n % 2 == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
