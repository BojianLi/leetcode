public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLength = maxLength(wordDict);
        boolean[] can = new boolean[s.length() + 1];
        can[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            can[i] = false;
            for (int j = i - 1; j >= i - maxLength && j >= 0; j--) {
                if (can[j] && wordDict.contains(s.substring(j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[s.length()];
    }
    private int maxLength(Set<String> wordDict) {
        int maxLength = 0;
        for (String s : wordDict) {
            maxLength = Math.max(maxLength, s.length());
        }
        return maxLength;
    }
}
