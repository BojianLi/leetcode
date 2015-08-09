public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int max = 1;
        for (int i : nums) {
            map.put(i, false);
        }
        for (int i : nums) {
            if (map.get(i)) {
                continue;
            }
            map.put(i, true);
            int cur = i;
            int curmax = 1;
            while (map.containsKey(++cur)) {
                curmax++;
                map.put(cur, true);
            }
            cur = i;
            while (map.containsKey(--cur)) {
                curmax++;
                map.put(cur, true);
            }
            max = Math.max(max, curmax);
        }
        return max;
    }
}
