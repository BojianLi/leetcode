public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int lo = 0;
        int hi = height.length - 1;
        while(lo < hi) {
            if (height[lo] < height[hi]) {
                max = Math.max(max, height[lo] * (hi - lo));
                lo++;
            } else {
                max = Math.max(max, height[hi] * (hi - lo));
                hi--;
            }
        }
        return max;
    }
}
