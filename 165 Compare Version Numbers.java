public class Solution {
    public int compareVersion(String version1, String version2) {
        int[] a = {0, 0};
        int[] b = {0, 0};
        while (a[1] < version1.length() || b[1] < version2.length()) {
            if (a[1] >= version1.length()) {
                a[0] = 0;
            } else {
                a = find(version1, a[1]);
            }
            if (b[1] >= version2.length()) {
                b[0] = 0;
            } else {
                b = find(version2, b[1]);
            }
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            }
        }
        return 0;
    }
    private int[] find(String s, int i) {
        int result = 0;
        while (i < s.length() && s.charAt(i) != '.') {
            result = result * 10 + s.charAt(i) - '0';
            i++;
        }
        int[] re = new int[2];
        re[0] = result;
        i++;
        re[1] = i;
        return re;
    }
}
