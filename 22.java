public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> pairs = new ArrayList<String>();
        if (n > 0) {
            getPairs(pairs, "", n, n);
        }
        return pairs;
    }
    
    private void getPairs(ArrayList<String> pairs, String parenthesis, int left, int right) {
        if (left > right || left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            pairs.add(parenthesis);
        }
        getPairs(pairs, parenthesis + "(", left - 1, right);
        getPairs(pairs, parenthesis + ")", left, right - 1);
    }
}
