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
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode node) {
        if(node == null) return 0;
        int l = findMax(node.left);
        int r = findMax(node.right);
        if(l + r + node.val > maxSum) maxSum = l + r + node.val;
        int re = Math.max(l, r);
        return (re + node.val < 0) ? 0 : re + node.val;
    }
}
