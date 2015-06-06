public class Solution {
    interface Operator {
        int eval(int x, int y);
    }
    
    private static final Map<String, Operator> map = new HashMap<String, Operator>() {{
                put("+", new Operator() {
                    public int eval(int x, int y) { return x + y;}
                });
                put("-", new Operator() {
                    public int eval(int x, int y) { return y - x;}
                });
                put("*", new Operator() {
                    public int eval(int x, int y) { return x * y;}
                });
                put("/", new Operator() {
                    public int eval(int x, int y) { return y / x;}
                });
        }};
        
        
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(map.containsKey(token)) {
                stack.push(map.get(token).eval(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
