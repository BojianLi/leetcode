public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new StringsComparator());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(strs[i]);
        }
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }
        if (i == n) {
            return "0";
        }
        return result.substring(i);
    }
    static class StringsComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return -(s1 + s2).compareTo(s2 + s1);
        }
    }
}
