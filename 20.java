public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('(', ')'); put('{', '}'); put('[', ']');
            }
        };
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                if(map.get(stack.pop()) != c) return false;
            }
        }
        return stack.empty();
    }
}
