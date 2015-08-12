public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new StringsComparator());
        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(strs[i]);
        }
        return result.toString();
    }
    static class StringsComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return -(s1 + s2).compareTo(s2 + s1);
        }
    }
}
