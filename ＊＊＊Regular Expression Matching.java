public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0, null);
    }
    private boolean isMatch(String s, int i, String p, int j, Character repeat) {
        if (i == s.length() && j == p.length()) return true;
        if (repeat != null && i == s.length()) return false;
        if (repeat != null) {
            if (repeat == '.' || s.charAt(i) == repeat) {
                return isMatch(s, i, p, j, null) || isMatch(s, i + 1, p, j, null) || isMatch(s, i + 1, p, j, repeat);
            }
            return isMatch(s, i, p, j, null);
        }
        if (i < s.length() && j == p.length()) return false;
        if (i == s.length()) {
            if ((p.length() - j) % 2 !=0) return false;
            while (j < p.length()) {
                if (p.charAt(++j) != '*') return false;
                j++;
            }
            return true;
        }
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            return isMatch(s, i, p, j + 2, p.charAt(j));
        }
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
            return isMatch(s, i + 1, p, j + 1, null);
        }
        return false;
    }
}
