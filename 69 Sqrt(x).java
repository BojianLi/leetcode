public class Solution {
    public int mySqrt(int x) {
        long lo = 0;
        long hi = x;
        while (lo <= hi) {
            long mid = (hi - lo) / 2 + lo;
            long xx = mid * mid;
            if (xx == x) {
                return (int)mid;
            } else if (xx > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) hi;
    }
}
