/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int length = points.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int lmax = 0;
            int dup = 0;
            map.put(Double.MIN_VALUE, 1);
            for (int j = i + 1; j < length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                } 
                double slope = points[i].x == points[j].x ? Double.MAX_VALUE : 
                                               0.0 + (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }
            for (int m : map.values()) {
                if (m + dup > max) {
                    max = m + dup;
                }
            }
        }
        return max;
    }
}
