/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        while (head != null) {
            ListNode node = head;
            for (int i = 0; i < k; i++) {
                head = head.next;
                if (head == null) {
                    break;
                }
            }
            if (head == null) {
                break;
            }
            ListNode start = node;
            ListNode end = head.next;
            head = node.next;
            node = node.next;
            ListNode pre = node;
            node = node.next;
            for (int i = 1; i < k; i++) {
                ListNode temp = node.next;
                node.next = pre;
                pre = node;
                node = temp;
            }
            head.next = end;
            start.next = pre;
        }
        return dummyHead.next;
    }
}
