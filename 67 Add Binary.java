public class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null) return null;
        if (a == null) return b;
        if (b == null) return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = m + n + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
