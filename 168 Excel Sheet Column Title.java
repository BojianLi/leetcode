public class Solution {
    public String convertToTitle(int n) {
        n = n - 1;
        StringBuilder sb = new StringBuilder();
        while (n >= 0) {
            sb.insert(0, (char)(n % 26 + 'A'));
            n = n / 26 - 1;
        }
        return sb.toString();
    }
}
