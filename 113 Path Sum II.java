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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathSum(root, sum, result, new ArrayList<Integer>());
        return result;
    }
    private void pathSum(TreeNode node, int sum, List<List<Integer>> result, List<Integer> array) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                array.add(node.val);
                result.add(new ArrayList<Integer>(array));
                array.remove(array.size() - 1);
            } else {
                return;
            }
        }
        array.add(node.val);
        pathSum(node.left, sum - node.val, result, array);
        pathSum(node.right, sum - node.val, result, array);
        array.remove(array.size() - 1);
    }
}
