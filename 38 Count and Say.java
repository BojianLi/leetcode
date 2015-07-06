public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = parse(result);
        }
        return result;
    }
    private String parse(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int repeat = 1;
            char c = s.charAt(i++);
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                i++;
                repeat++;
            }
            sb.append(repeat);
            sb.append(c);
        }
        return sb.toString();
    }
}
