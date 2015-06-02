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
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root) == -1) return false;
        return true;
    }
    private int maxDepth(TreeNode node) {
        if(node == null) return 0;
        int a = maxDepth(node.left);
        if(a == -1) return -1;
        int b = maxDepth(node.right);
        if(b == -1) return -1;
        if(Math.abs(a - b) > 1) return -1;
        return Math.max(a, b) + 1;
    }
}
