/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null || l2 != null) {
            int a = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int b = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if(a < b) {
                p.next = new ListNode(a);
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = new ListNode(b);
                p = p.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
