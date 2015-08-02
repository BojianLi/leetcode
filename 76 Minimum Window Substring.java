public class Solution {
    public String minWindow(String s, String t) {
        int min = s.length() + 1;
        String result = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int[] targetHash = new int[256];
        for (char c : t.toCharArray()) {
            targetHash[c]++;
        }
        int targetNum = t.length();
        int sNum = 0;
        int i = 0, j = 0;
        for (j = 0; j < s.length(); j++) {
            if (targetHash[s.charAt(j)] > 0) {
                sNum++;
            }
            targetHash[s.charAt(j)]--;
            while (sNum == targetNum) {
                targetHash[s.charAt(i)]++;
                if (targetHash[s.charAt(i)] > 0) {
                    sNum--;
                    if (min > j - i + 1) {
                        min = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
                i++;
            }
        }
        return result;
    }
}
