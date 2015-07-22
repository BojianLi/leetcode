public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (beginWord == null || endWord == null) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordDict.remove(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            Queue<String> q = new LinkedList<String>();
            while (!queue.isEmpty()) {
                String current = queue.poll();
                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < current.length(); j++) {
                        if (current.charAt(j) == c) {
                            continue;
                        }
                        String tmp = replace(current, j, c);
                        if (tmp.equals(endWord)) {
                            return length + 1;
                        }
                        if (wordDict.contains(tmp)) {
                            q.offer(tmp);
                            wordDict.remove(tmp);
                        }
                    }
                }
            }
            queue = q;
            length++;
        }
        return 0;
    }
    private String replace(String current, int j, char c) {
        char[] chars = current.toCharArray();
        chars[j] = c;
        return new String(chars);
    }
}
