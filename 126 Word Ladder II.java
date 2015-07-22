public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        boolean found = false;
        List<List<String>> result = new ArrayList<List<String>>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        Queue<List<String>> queueList = new LinkedList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(start);
        queueList.offer(new ArrayList<String>(list));
        while (!queue.isEmpty() && !found) {
            int n = queue.size();
            List<String> removes = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String current = queue.poll();
                list = queueList.poll();
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (current.charAt(j) == c) {
                            continue;
                        }
                        String tmp = replace(current, j, c);
                        if (tmp.equals(end)) {
                            found = true;
                            list.add(tmp);
                            result.add(new ArrayList<String>(list));
                            list.remove(list.size() - 1);
                            continue;
                        }
                        if (dict.contains(tmp)) {
                            list.add(tmp);
                            queueList.offer(new ArrayList<String>(list));
                            list.remove(list.size() - 1);
                            queue.add(tmp);
                            removes.add(tmp);
                        }
                    }
                }
            }
            for (String remove : removes) {
            	dict.remove(remove);
            }
        }
        return result;
    }
    private String replace(String current, int j, char c) {
        char[] chars = current.toCharArray();
        chars[j] = c;
        return new String(chars);
    }
}
