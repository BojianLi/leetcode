public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        int dot = 0;
        path = path + "/";
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '.') {
                dot++;
                sb.append('.');
            } else if (c == '/'){
                if (dot == 2) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    sb = new StringBuilder();
                    dot = 0;
                } else if (dot == 1) {
                    dot = 0;
                    sb = new StringBuilder();
                } else {
                    if (sb.length() != 0) {
                        stack.push(sb.toString());
                    }
                    sb = new StringBuilder();
                    dot = 0;
                }
            } else{
                dot = 0;
                sb.append(c);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        } else {
            while (!stack.isEmpty()) {
                sb.insert(0, "/" + stack.pop());
            }
        }
        return sb.toString();
    }
}
