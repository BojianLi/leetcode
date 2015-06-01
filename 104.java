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
    public int maxDepth(TreeNode root) {
        return help(root);
    }
    private int help(TreeNode node) {
        if(node == null) return 0;
        return Math.max(help(node.left), help(node.right)) + 1;
    }
}
