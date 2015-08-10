/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode reverse = reverse(mid.next);
        mid.next = null;
        merge(head, reverse);
    }
    private void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            dummy.next = head1;
            head1 = head1.next;
            dummy = dummy.next;
            dummy.next = head2;
            dummy = dummy.next;
            head2 = head2.next;
        }
        if (head1 != null) {
            dummy.next = head1;
        }
    }
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
