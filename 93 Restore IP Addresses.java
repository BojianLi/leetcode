public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        List<String> list = new ArrayList<String>();
        helper(result, list, s, 0);
        return result;
    }
    private void helper(List<String> result, List<String> list, String s, int index) {
        if (list.size() == 4) {
            if (index == s.length()) {
                add(result, list);
            }
            return;
        }
        for (int i = index; i < s.length() && i < index + 3; i++) {
            String tmp = s.substring(index, i + 1);
            if (valid(tmp)) {
                list.add(tmp);
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private void add(List<String> result, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        result.add(sb.toString());
    }
    private boolean valid(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }
        int num = Integer.parseInt(s);
        return (num >= 0 && num <= 255);
    }
}
