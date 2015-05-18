public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int maxLen = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if(map[s.charAt(j)] >= i) {
                if (maxLen < j - i) {
                    maxLen = j - i;
                }
                i = map[s.charAt(j)] + 1;
            }
            map[s.charAt(j)] = j;
        }
        if (maxLen < s.length() - i) {
            maxLen = s.length() - i;
        }
        return maxLen;
    }
}
