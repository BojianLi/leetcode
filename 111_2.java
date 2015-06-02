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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int dep = 1;
        TreeNode rightMost = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode curr = root;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            if(curr.left == null && curr.right == null) break;
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
            if(curr == rightMost) {
                dep++;
                rightMost = (curr.right == null) ? curr.left : curr.right;
            }
        }
        return dep;
    }
}
