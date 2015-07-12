public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int accumulated = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    accumulated = 0;
                } else {
                    int match = stack.pop();
                    int matLen;
                    if (stack.isEmpty()) {
                        matLen = i - match + 1;
                        matLen += accumulated;
                        accumulated = matLen;
                    } else {
                        matLen = i - stack.peek();
                    }
                    if (matLen > max) {
                        max = matLen;
                    }
                }
            }
        }
        return max;
    }
}
