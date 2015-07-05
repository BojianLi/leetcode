/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }
        ListNode q = dummyHead;
        while (p != null) {
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        return dummyHead.next;
    }
}
