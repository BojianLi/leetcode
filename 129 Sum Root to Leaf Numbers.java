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
    public int sumNumbers(TreeNode root) {
        return sum(0, root);
        
    }
    private int sum(int sum, TreeNode node) {
        if (node == null) {
            return 0;
        }
        sum = 10 * sum + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return sum(sum, node.left) + sum(sum, node.right);
    }
}
