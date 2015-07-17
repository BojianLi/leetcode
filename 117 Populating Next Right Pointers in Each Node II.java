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
        TreeLinkNode leftEnd = root;
        while (leftEnd != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode cur = leftEnd;
            TreeLinkNode belowCur = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    belowCur.next = cur.left;
                    belowCur = belowCur.next;
                }
                if (cur.right != null) {
                    belowCur.next = cur.right;
                    belowCur = belowCur.next;
                }
                cur = cur.next;
            }
            leftEnd = dummy.next;
        }
    }
}
