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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> twopath = new ArrayList<List<TreeNode>>();
        path(twopath, new ArrayList<TreeNode>(), root, p, q);
        int length = Math.min(twopath.get(0).size(), twopath.get(1).size());
        for (int i = 0; i < length; i++) {
            if (twopath.get(0).get(i).val != twopath.get(1).get(i).val) {
                return twopath.get(0).get(i - 1);
            }
        }
        return twopath.get(0).get(length - 1);
    }
    private void path(List<List<TreeNode>> twopath, List<TreeNode> path, TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || twopath.size() == 2) {
            return;
        }
        path.add(root);
        if (root.equals(p)) {
            twopath.add(new ArrayList<TreeNode>(path));
        } else if (root.equals(q)) {
            twopath.add(new ArrayList<TreeNode>(path));
        }
        path(twopath, path, root.left, p, q);
        path(twopath, path, root.right, p, q);
        path.remove(path.size() - 1);
    }
}
