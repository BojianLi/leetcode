//out of time don't know why

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                int index = map.get(s.charAt(j));
                if(index >= i) {
                    if (maxLen < j - i) {
                        maxLen = j - i;
                    }
                    i = index + 1;
                    System.out.println(i);
                }
            }
            map.put(s.charAt(j), j);
        }
        if (maxLen < s.length() - i) {
            maxLen = s.length() - i;
        }
        return maxLen;
    }
}
