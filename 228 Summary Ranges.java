public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) {
            return list;
        }
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end = i;
            } else {
                addString(list, start, end, nums);
                start = i;
                end = i;
            }
        }
        addString(list, start, end, nums);
        return list;
    }
    private void addString(List<String> list, int start, int end, int[] nums) {
        if (start == end) {
            list.add("" + nums[start]);
        } else {
            list.add(nums[start] + "->" + nums[end]);
        }
    }
}
