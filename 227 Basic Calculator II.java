public class Solution {
    public int calculate(String s) {
        Stack<Character> operator = new Stack<Character>();
        Stack<Integer> operand = new Stack<Integer>();
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '/' || c == '*') {
                operand.push(num);
                num = 0;
                if (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
                    compute(operator, operand);
                }
                operator.push(c);
            } else if (c == '+' || c == '-') {
                operand.push(num);
                num = 0;
                while (!operator.isEmpty()) {
                    compute(operator, operand);
                }
                operator.push(c);
            }
            i++;
        }
        operand.push(num);
        while (!operator.isEmpty()) {
            compute(operator, operand);
        }
        return operand.pop();
    }
    private void compute(Stack<Character> operator, Stack<Integer> operand) {
        char c = operator.pop();
        int b = operand.pop();
        int a = operand.pop();
        switch (c) {
            case '+' : operand.push(a + b);
                       break;
            case '-' : operand.push(a - b);
                       break;
            case '*' : operand.push(a * b);
                       break;
            case '/' : operand.push(a / b);
                       break;
        }
    }
}
