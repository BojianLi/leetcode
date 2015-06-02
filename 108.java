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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return BST(nums, start, end);
    }
    private TreeNode BST(int[] nums, int start, int end) {
        if(start > end) return null;
        int m = (start + end) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = BST(nums, start, m - 1);
        node.right = BST(nums, m + 1, end);
        return node;
    }
}
