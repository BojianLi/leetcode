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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        traverse(root, result, 0);
        return result;
    }
    private void traverse(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(node.val);
        }
        traverse(node.right, result, depth + 1);
        traverse(node.left, result, depth + 1);
    }
}
