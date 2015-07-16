public class Solution {
    int result;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2') {
                    result[i] = 0;
                } else {
                    result[i] = result[i - 2];
                }
            } else if (s.charAt(i - 2) == '1') {
                result[i] = result[i - 1] + result[i - 2];
            } else if (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                result[i] = result[i - 1] + result[i - 2];
            } else {
                result[i] = result[i - 1];
            }
        }
        return result[s.length()];
    }
}
