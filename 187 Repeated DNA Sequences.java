public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<String> stringSet = new HashSet<String>();
        Set<Integer> intSet = new HashSet<Integer>();
        for (int i = 0; i < s.length() - 9; i++) {
            String string = s.substring(i, i + 10);
            int unicode = encode(string);
            if (intSet.contains(unicode)) {
                stringSet.add(string);
            } else {
                intSet.add(unicode);
            }
        }
        for (String string : stringSet) {
            result.add(string);
        }
        return result;
    }
    private int encode(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'A' :  sum = sum * 4;
                            break;
                case 'C' :  sum = sum * 4 + 1;
                            break;
                case 'G' :  sum = sum * 4 + 2;
                            break;
                case 'T' :  sum = sum * 4 + 3;
                            break;
                default  :
            }
        }
        return sum;
    }
}
