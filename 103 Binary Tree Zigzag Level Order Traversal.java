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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean fromLeftToRight = true;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> tmp = new Stack<TreeNode>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (fromLeftToRight) {
                    if (node.left != null) {
                        tmp.push(node.left);
                    }
                    if (node.right != null) {
                        tmp.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        tmp.push(node.right);
                    }
                    if (node.left != null) {
                        tmp.push(node.left);
                    }
                }
            }
            fromLeftToRight = !fromLeftToRight;
            stack = tmp;
            result.add(list);
        }
        return result;
    }
}
