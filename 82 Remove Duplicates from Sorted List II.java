/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        boolean drop = false;
        ListNode node1 = dummyHead;
        ListNode node2 = head;
        ListNode node3 = head.next;
        while(node3 != null) {
            if (node3.val == node2.val) {
                drop = true;
                node3 = node3.next;
            } else if (drop) {
                node2 = node3;
                node3 = node3.next;
                node1.next = node2;
                drop = false;
            } else {
                node1.next = node2;
                node1 = node1.next;
                node2 = node3;
                node3 = node3.next;
            }
        }
        if(drop) {
            node1.next = null;
        }
        return dummyHead.next;
    }
}
