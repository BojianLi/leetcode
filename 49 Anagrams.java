public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            int[] character = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                character[strs[i].charAt(j) - 'a']++;
            }
            int hash = getHash(character);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(strs[i]);
        }
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
    }
    private int getHash(int[] count) {
        int hash = 0;
        int a = 2;
        int b = 3;
        for (int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
}
