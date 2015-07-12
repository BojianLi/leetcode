public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int num = words.length;
        int length = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        for (int i = 0; i <= s.length() - num * length; i++) {
            Map<String, Integer> map2 = new HashMap<String, Integer>();
            int j;
            for (j = 0; j < num; j++) {
                int index = i + j * length;
                String word = s.substring(index, index + length);
                if (!map.containsKey(word)) {
                    break;
                } else if (!map2.containsKey(word)) {
                    map2.put(word, 1);
                } else {
                    map2.put(word, map2.get(word) + 1);
                }
                if (map2.get(word) > map.get(word)) {
                    break;
                }
            }
            if (j == num) {
                result.add(i);
            }
        }
        return result;
    }
}
