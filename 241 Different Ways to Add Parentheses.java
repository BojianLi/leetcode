public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return result;
        }
        Map<String, List<Integer>> dpMap = new HashMap<String, List<Integer>>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String s = input.substring(0, i);
                List<Integer> left;
                if (dpMap.containsKey(s)) {
                    left = dpMap.get(s);
                } else {
                    left = diffWaysToCompute(s);
                    dpMap.put(s, left);
                }
                s = input.substring(i + 1);
                List<Integer> right;
                if (dpMap.containsKey(s)) {
                    right = dpMap.get(s);
                } else {
                    right = diffWaysToCompute(s);
                    dpMap.put(s, right);
                }
                for (int l : left) {
                    for (int r : right) {
                        int add = 0;
                        switch (c) {
                            case '+' : add = l + r;
                                       break;
                            case '-' : add = l - r;
                                       break;
                            case '*' : add = l * r;
                                       break;
                            default :
                        }
                        result.add(add);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
