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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);
        TreeNode big = null;
        TreeNode small = null;
        list.add(0, new TreeNode(Integer.MIN_VALUE));
        list.add(new TreeNode(Integer.MAX_VALUE));
        for (int i = 1; i < list.size() - 1; i++) {
            if (big == null && list.get(i).val > list.get(i - 1).val && list.get(i).val > list.get(i + 1).val) {
                big = list.get(i);
            }
            if (list.get(i).val < list.get(i - 1).val && list.get(i).val < list.get(i + 1).val) {
                small = list.get(i);
            }
        }
        int tmp = big.val;
        big.val = small.val;
        small.val = tmp;
    }
    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }
}


////////////////



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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (node.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            if (first != null) {
                second = node;
            }
        } 
        pre = node;
        traverse(node.right);
    }
}
