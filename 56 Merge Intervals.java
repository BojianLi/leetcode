/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new intervalComparator());
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= pre.end) {
                pre.end = Math.max(pre.end, intervals.get(i).end);
            } else {
                result.add(pre);
                pre = intervals.get(i);
            }
        }
        result.add(pre);
        return result;
    }
    private class intervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
