public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            set.add(n);
            n = convert(n);
        }
        return n == 1;
    }
    private int convert(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }
}
