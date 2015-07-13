public class Solution {
    public boolean isMatch(String s, String p) {
        int plen = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                plen++;
            }
        }
        if (plen > s.length()) {
            return false;
        }
        int si = 0;
        int pi = 0;
        int star = -1;
        int pp = -1;
        while (si < s.length() || pi < p.length()) {
            if (si < s.length() && pi < p.length()) {
                if (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi)) {
                    si++;
                    pi++;
                    continue;
                }
                if (p.charAt(pi) == '*') {
                    pp = pi + 1;
                    star = si;
                    pi++;
                    continue;
                }
            }
            if (si >= s.length() && pi < p.length()) {
                while (p.charAt(pi) == '*') {
                    pi++;
                    if (pi == p.length()) {
                        return true;
                    }
                }
            }
            if (star != -1) {
                if (star > s.length() && pi < p.length()) {
                    return false;
                }
                star++;
                si = star;
                pi = pp;
                continue;
            }
            
            return false;
        }
        return true;
    }
}
