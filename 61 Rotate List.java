/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int size = 0;
        ListNode oldHead = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        k %= size;
        head = oldHead;
        if (k == 0) {
            return head;
        }
        ListNode ahead = head;
        for (int i = 0; i < k; i++) {
            ahead = ahead.next;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            head = head.next;
        }
        ahead.next = oldHead;
        ListNode temp = head.next;
        head.next = null;
        return temp;
    }
}
