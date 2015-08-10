public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> list = new ArrayList<String>();
        helper(result, list, 0, s);
        return result;
    }
    private void helper(List<List<String>> result, List<String> list, int index, String s) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String pre = s.substring(index, i);
            if (!isPalindrome(pre)) {
                continue;
            }
            list.add(pre);
            helper(result, list, i, s);
            list.remove(list.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
