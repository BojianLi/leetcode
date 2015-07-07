public class Solution {
    public String multiply(String num1, String num2) {
        int offset = 0;
        int i = num1.length() - 1;
        String result = "0";
        while (i >= 0) {
            String mul = multi(num1.charAt(i--), num2, offset++);
            result = add(result, mul);
        }
        return result;
    }
    
    private String multi(char num1, String num2, int offset) {
        if (num1 == '0') return "0";
        if (num2.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num2.length() - 1;
        int n1 = num1 - '0';
        while (i >= 0) {
            int n2 = num2.charAt(i--) - '0';
            int sum = n2 * n1 + carry;
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        for (int j = 0; j < offset; j++) {
            sb.append('0');
        }
        return sb.toString();
    }
    
    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        boolean carry = false;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2;
            if (carry) sum++;
            sb.insert(0, sum % 10);
            carry = sum >= 10;
        }
        if (carry) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
