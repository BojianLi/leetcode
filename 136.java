public class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int x : nums) {
            num ^= x;
        }
        return num;
    }
}
