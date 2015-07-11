public class Solution {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        int i = 0;
        boolean leftP = true;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case ' ':   i++;
                            break;
                case '(':   leftP = true;
                            i++;
                            break;
                case ')':   int a =  operands.isEmpty() ? 0 : operands.pop();
                            int b =  operands.isEmpty() ? 0 : operands.pop();
                            char cc = operators.isEmpty() ? '+' : operators.pop();
                            operands.push(compute(a, b, cc));
                            i++;
                            break;
                case '-':   operators.push(c);
                            i++;
                            break;
                case '+':   operators.push(c);
                            i++;
                            break;
                default :   int result = 0;
                            while (c >= '0' && c <= '9') {
                            	i++;
                                result = result * 10 + c - '0';
                                if (i >= s.length()) break;
                                c = s.charAt(i);
                            }
                            operands.push(result);
                            if (leftP) {
                                leftP = false;
                            } else {
                                operands.push(compute(operands.pop(), operands.pop(), operators.pop()));
                            }
            }
            
        }
        return operands.pop();
    }
    private int compute(int a, int b, char c) {
        switch (c) {
            case '+': return a + b;
            case '-': return b - a;
        }
        return 0;
    }
}
