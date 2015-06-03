public class Solution {
    private static final Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('I', 1);  put('V', 5);   put('X', 10);
            put('L', 50); put('C', 100); put('D', 500);
            put('M', 1000);
        }
    };
    public int romanToInt(String s) {
        int total = 0;
        int pre = 0;
        for(char c : s.toCharArray()) {
            int temp = map.get(c);
            total += (temp > pre) ? (temp - 2 * pre) : temp;
            pre = temp;
        }
        
        
        return total;
    }
}
