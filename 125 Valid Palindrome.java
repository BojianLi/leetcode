public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int ii = compute(s.charAt(i));
            while (ii == -1 && i < j) {
                i++;
                ii = compute(s.charAt(i));
            }
            int jj = compute(s.charAt(j));
            while (jj == -1 && j > i) {
                j--;
                jj = compute(s.charAt(j));
            }
            if (ii != jj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private int compute(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 'a';
        } else if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return c;
        } else {
            return -1;
        }
    }
}
