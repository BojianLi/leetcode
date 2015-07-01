public class Solution {
    public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
        }
        String result = "";
        int max = 0;
        int length = s.length();
        for (int i = 0; i < 2 * length + 1; i++) {
            int count = 0, l = 0, r = 0;
            if (i % 2 == 0) {
                count = 0;
                l = i / 2 - 1;
                r = l + 1;
            } else {
                l = i / 2 - 1;
                r = l + 2;
                count = 1;
            }
            while (l >= 0 && r <= length - 1 && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count = count + 2;
            }
            if (count > max) {
                result = s.substring(l + 1, r);
                max = count;
            }
        }
		return result;
    }
}
