public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || k > nums.length) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length - k + 1];
        int i = 0;
        for (int now : nums) {
            i++;
            while (!deque.isEmpty() && deque.peekLast() < now) {
                deque.pollLast();
            }
            deque.offerLast(now);
            if (i > k && deque.peekFirst() == nums[i - k - 1]) {
                deque.pollFirst();
            }
            if (i >= k) {
                ans[i - k] = deque.peekFirst();
            }
        }
        return ans;
    }
}
