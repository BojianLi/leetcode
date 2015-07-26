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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        int l = 0, r = intervals.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (newInterval.start > intervals.get(mid).start) {
                l = mid + 1;
            } else {
                r= mid - 1;
            }
        }
        int left = l - 1;
        l = 0;
        r = intervals.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (newInterval.end > intervals.get(mid).end) {
                l = mid + 1;
            } else {
                r= mid - 1;
            }
        }
        int right = l;
        if (left == right) {
            return intervals;
        }
        for (int i = 0; i < left; i++) {
            result.add(intervals.get(i));
        }
        if (left >= 0) {
        if (intervals.get(left).end >= newInterval.start) {
            newInterval.start = intervals.get(left).start;
        } else {
            result.add(intervals.get(left));
        }
        }
        if (right >= intervals.size()) {
            result.add(newInterval);
            return result;
        }
        if (intervals.get(right).start <= newInterval.end) {
            newInterval.end = intervals.get(right).end;
            result.add(newInterval);
        } else {
            result.add(newInterval);
            result.add(intervals.get(right));
        }
        for (int i = right + 1; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }
        return result;
    }
}
