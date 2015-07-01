public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                char c = map.get(s.charAt(i));
                if (c != t.charAt(i)) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i) ,t.charAt(i));
            }
        }
        return true;
    }
}
