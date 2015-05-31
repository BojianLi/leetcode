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
    Integer pre;
    public boolean isValidBST(TreeNode root) {
        pre = null;
        traverse(root);
    }
    private void traverse(TreeNode node) {
        if(node == null) return;
        if(!traverse(node.left)) return false;
        if(pre != null && node.val < pre) {
            pre = node.val;
            return false;
        }
        traverse(node.right);
        return true;
    }
}
