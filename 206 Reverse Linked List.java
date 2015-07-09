/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode ahead = head.next;
        ListNode pre = null;
        while (ahead != null) {
            head.next = pre;
            pre = head;
            head = ahead;
            ahead = ahead.next;
        }
        head.next = pre;
        return head;
    }
}
