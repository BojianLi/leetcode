/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode list;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int n = 0;
        ListNode p = head.next;
        while(p != null) {
            n++;
            p = p.next;
        }
        list = head;
        return sortedListToBST(0, n);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if(start > end) return null;
        int m = (start + end) / 2;
        TreeNode left = sortedListToBST(start, m - 1);
        TreeNode node = new TreeNode(list.val);
        list = list.next;
        node.left = left;
        node.right = sortedListToBST(m + 1, end);
        return node;
    }
}
