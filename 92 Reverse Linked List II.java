/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode node = dummyHead;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode start = node;
        node = node.next;
        ListNode end = node;
        
        ListNode pre = null;
        while (m <= n) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
            m++;
        }
        end.next = node;
        start.next = pre;
        return dummyHead.next;
    }
}
