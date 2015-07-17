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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
    int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int position = findKey(inorder, inStart, inEnd, postorder[postEnd]);
        root.left = buildTree(inorder, inStart, position - 1, postorder, postStart, position - 1 - inStart + postStart);
        root.right = buildTree(inorder, position + 1, inEnd, postorder, position - inEnd + postEnd, postEnd - 1);
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
