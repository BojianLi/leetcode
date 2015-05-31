/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private static final Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode x, ListNode y) {
            return x.val - y.val;
        }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        Queue<ListNode> q = new PriorityQueue<>(k, comparator);
        for(int i = 0; i < k; i++) {
            if(lists[i] != null) {
                q.add(lists[i]);
            }
        }
        while(!q.isEmpty()) {
            ListNode n = q.poll();
            p.next = n;
            if(n.next != null) {
                q.add(n.next);
            }
            p = p.next;
        }
        return dummyHead.next;
        
    }
}
