public class Solution {
    public int trap(int[] height) {
        int max = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxHeight]) {
                maxHeight = i;
            }
        }
        int pre = 0;
        for (int i = 0; i < maxHeight; i++) {
            if (height[i] > pre) {
                max += (height[i] - pre) * (maxHeight - i);
                pre = height[i];
            }
            max -= height[i];
        }
        pre = 0;
        for (int i = height.length - 1; i > maxHeight; i--) {
            if (height[i] > pre) {
                max += (height[i] - pre) * (i - maxHeight);
                pre = height[i];
            }
            max -= height[i];
        }
        return max;
    }
}
