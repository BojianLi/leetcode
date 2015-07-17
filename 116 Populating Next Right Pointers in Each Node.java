/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode p1 = root;
        TreeLinkNode p2 = p1;
        while (p1 != null && p1.left != null) {
            while (p2 != null) {
                p2.left.next = p2.right;
                if (p2.next != null) {
                    p2.right.next = p2.next.left;
                }
                p2 = p2.next;
            }
            p1 = p1.left;
            p2 = p1;
        }
    }
}
