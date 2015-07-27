public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int wordCount = words.length;
        int length = 0;
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            if (length + words[i].length() > maxWidth) {
                addToRe(words, maxWidth, start, i - 1, result);
                start = i;
                length = 0;
            }
            length += words[i].length() + 1;
        }
        addToReLastLine(words, maxWidth, start, wordCount - 1, result);
        return result;
    }
    private void addToRe(String[] words, int maxWidth, int start, int end, List<String> result) {
        int space = maxWidth;
        for (int i = start; i <= end; i++) {
            space -= words[i].length();
        }
        int gap = end - start;
        StringBuilder sb = new StringBuilder();
        if (gap == 0) {
            sb.append(words[start]);
            for (int i = 0; i < space; i++) {
                sb.append(' ');
            }
            result.add(sb.toString());
            return;
        }
        int even = space / gap;
        int extra = space % gap;
        sb.append(words[start]);
        for (int i = start + 1; i <= end; i++) {
            for (int j = 0; j < even; j++) {
                sb.append(' ');
            }
            if (extra > 0) {
                sb.append(' ');
                extra--;
            }
            sb.append(words[i]);
        }
        result.add(sb.toString());
    }
    private void addToReLastLine(String[] words, int maxWidth, int start, int end, List<String> result) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for (int i = start + 1; i <= end; i++) {
            sb.append(' ');
            sb.append(words[i]);
        }
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(' ');
        }
        result.add(sb.toString());
    }
}
