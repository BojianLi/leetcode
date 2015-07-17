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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[]  preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int position = findKey(inorder, inStart, inEnd, preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + position - inStart, inorder, inStart, position - 1);
        root.right = buildTree(preorder, preStart + position - inStart + 1, preEnd, inorder, position + 1, inEnd);
        return root;
    }
    private int findKey(int[] inorder, int inStart, int inEnd, int key) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
