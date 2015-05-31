/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int end = lists.length;
        if(end == 0) {
            return null;
        }
        end = end - 1;
        while(end > 0) {
            int begin = 0;
            while(begin < end) {
                lists[begin] = merge(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(n1 != null || n2 != null) {
            int a = (n1 == null) ? Integer.MAX_VALUE : n1.val;
            int b = (n2 == null) ? Integer.MAX_VALUE : n2.val;
            if(a < b) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
