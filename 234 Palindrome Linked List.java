/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        p = head;
        ListNode pre = null;
        for (int i = 0; i < (n - 1) / 2; i++) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        ListNode q = p.next;
        p.next = pre;
        if (n % 2 == 1) {
            p = p.next;
        }
        while (p != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
