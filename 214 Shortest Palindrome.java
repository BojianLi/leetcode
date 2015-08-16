public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] c = s.toCharArray();
        if (isPalindrome(c, c.length - 1)) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (isPalindrome(c, i - 1)) {
                reverseappend(sb, c, i);
                sb.append(s);
                break;
            }
        }
        return sb.toString();
    }
    private void reverseappend(StringBuilder sb, char[] c, int start) {
        for (int i = c.length - 1; i >= start; i--) {
            sb.append(c[i]);
        }
    }
    private boolean isPalindrome(char[] c, int end) {
        int start = 0;
        while (start < end) {
            if (c[start] != c[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}





///////KMP

