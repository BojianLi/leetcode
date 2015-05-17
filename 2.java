public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        if (l1 == null) return null;
        int a = l1.val + l2.val + up;
        ListNode r = new ListNode(a % 10);
        ListNode n = r;
        up = a / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            a = l1.val + l2.val + up;
            r.next = new ListNode(a % 10);
            r = r.next;
            up = a / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            a = l1.val + up;
            r.next = new ListNode(a % 10);
            r = r.next;
            up = a / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            a = l2.val + up;
            r.next = new ListNode(a % 10);
            r = r.next;
            up = a / 10;
            l2 = l2.next;
        }
        if (up != 0) {
            r.next = new ListNode(up);
        }
        return n;
        
    }
}
