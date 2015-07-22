public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(' ');
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
