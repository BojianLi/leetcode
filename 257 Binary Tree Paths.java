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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root != null) {
            List<Integer> list = new ArrayList<Integer>();
            binaryTreePaths(root, list, result);
        }
        return result;
    }
    private void binaryTreePaths(TreeNode node, List<Integer> list, List<String> result) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            add(list, result);
            list.remove(list.size() - 1);
            return;
        }
        if (node.left != null) {
            binaryTreePaths(node.left, list, result);
        }
        if (node.right != null) {
            binaryTreePaths(node.right, list, result);
        }
        list.remove(list.size() - 1);
        
    }
    private void add(List<Integer> list, List<String> result) {
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append("->" + list.get(i));
        }
        result.add(sb.toString());
    }
}
