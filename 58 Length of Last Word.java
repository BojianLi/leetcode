public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean newWord = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newWord = true;
            } else if (newWord){
                length = 1;
                newWord = false;
            } else {
                length++;
            }
        }
        return length;
    }
}
