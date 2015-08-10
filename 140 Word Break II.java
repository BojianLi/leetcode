public class Solution {
    private boolean[] possible;
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict.isEmpty()) {
            return result;
        }
        possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (wordDict.contains(s.substring(i, j + 1)) && possible[j + 1]) {
                    possible[i] = true;
                }
            }
        }
        helper(s, wordDict, list, result, 0);
        return result;
    }
    private void helper(String s, Set<String> wordDict, List<String> list, List<String> result, int index) {
        if (index == s.length()) {
            addWord(result, list);
            return;
        }
        if (!possible[index]) {
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);
            if (wordDict.contains(cur)) {
                list.add(cur);
                helper(s, wordDict, list, result, i);
                list.remove(list.size() - 1);
            }
        }
    }
    private void addWord(List<String> result, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        result.add(sb.toString());
    }
}
