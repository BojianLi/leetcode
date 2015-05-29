/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode pre = dummy;
        while(p != null && p.next != null) {
            ListNode q = p.next;
            ListNode r = q.next;
            q.next = p;
            p.next = r;
            pre.next = q;
            pre = p;
            p = r;
        }
        return dummy.next;
    }
}
