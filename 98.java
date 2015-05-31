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
    public boolean isValidBST(TreeNode root) {
        return isItValid(root, null, null);
    }
    private boolean isItValid(TreeNode t, Integer low, Integer high) {
        if(t == null) return true;
        return ((low == null) ? true : t.val > low) && ((high == null) ? true : t.val < high) && isItValid(t.left, low, t.val) && isItValid(t.right, t.val, high);
    }
}
