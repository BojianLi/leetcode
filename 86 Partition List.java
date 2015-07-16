/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p1 = dummyHead;
        while (p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }
        ListNode p2 = p1;
        while (p2.next != null) {
            if (p2.next.val >= x) {
                p2 = p2.next;
            } else {
                ListNode temp = p2.next;
                p2.next = p2.next.next;
                temp.next = p1.next;
                p1.next = temp;
                p1 = p1.next;
            }
        }
        return dummyHead.next;
    }
}
