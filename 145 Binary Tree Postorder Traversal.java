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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new LinkedList<Integer>();
        if (root != null) {
            stack.push(root);
        }
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }
}
