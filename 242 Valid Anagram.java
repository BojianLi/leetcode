public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int[] sHash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            sHash[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            sHash[t.charAt(i)]--;
            if (sHash[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
