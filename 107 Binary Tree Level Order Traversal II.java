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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList<List<Integer>>();
        traverse(root, 0);
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        for (int i = result.size() - 1; i >= 0; i--) {
            re.add(result.get(i));
        }
        return re;
    }
    private void traverse(TreeNode node, int level) {
        if (node == null) return;
        if (level == result.size()) {
            List<Integer> array = new ArrayList<Integer>();
            array.add(node.val);
            result.add(array);
        } else {
            result.get(level).add(node.val);
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
    
}
