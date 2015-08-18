public class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        Queue<Long> q2 = new LinkedList<Long>();
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        q2.offer(2l);
        q3.offer(3l);
        q5.offer(5l);
        long val = 0;
        for (int i = 1; i < n; i++) {
            val = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            if (val == q2.peek()) {
                q2.poll();
                q2.offer(val * 2);
                q3.offer(val * 3);
                q5.offer(val * 5);
            } else if(val == q3.peek()) {
                q3.poll();
                q3.offer(val * 3);
                q5.offer(val * 5);
            } else {
                q5.poll();
                q5.offer(val * 5);
            }
        }
        return (int)val;
    }
}
