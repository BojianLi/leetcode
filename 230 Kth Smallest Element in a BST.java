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
    private int count;
    private int result;
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        help(root, k);
        return result;
    }
    private void help(TreeNode node, int k) {
        if (node == null) return;
        help(node.left, k);
        if (++count == k) {
            result = node.val;
            return;
        } else if (count > k) {
            return;
        }
        help(node.right, k);
        return;
    }
}
