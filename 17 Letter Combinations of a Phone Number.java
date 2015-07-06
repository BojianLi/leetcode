public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        return lc(new ArrayList<String>(), digits, 0, "");
    }
    
    private List<String> lc(List<String> list, String digits, int index, String item) {
        if (index == digits.length()) {
            list.add(item);
            return list;
        }
        char c = digits.charAt(index);
        String g = getString(c);
        for (int i = 0; i < g.length(); i++) {
            list = lc(list, digits, index + 1, item + g.charAt(i));
        }
        return list;
    }
    
    private String getString(char num) {
        switch(num) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
}
