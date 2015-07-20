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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int h = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            h++;
        }
        if (left == null) {
            return (1 << h) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
