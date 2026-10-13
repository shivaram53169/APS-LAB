/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches either p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return a non-null node, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null result (or null if neither contained p or q)
        return left != null ? left : right;
    }
}