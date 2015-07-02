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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = traverse(result, root, 0);
        return result;
    }
    private List<List<Integer>> traverse(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) return result;
        if (level == result.size()) {
            List<Integer> array = new ArrayList<Integer>();
            array.add(node.val);
            result.add(array);
        } else {
            result.get(level).add(node.val);
        }
        result = traverse(result, node.left, level + 1);
        result = traverse(result, node.right, level + 1);
        return result;
    }
}
