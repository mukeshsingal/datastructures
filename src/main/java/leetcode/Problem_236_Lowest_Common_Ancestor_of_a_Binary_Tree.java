package leetcode;

public class Problem_236_Lowest_Common_Ancestor_of_a_Binary_Tree {




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;

        if(root == p || root == q) {
            if(helper(root.left, p, q) || helper(root.right, p, q)) {
                result = root;
                return false;
            }
            return true;
        }
        if(result != null) {
            return false;
        }
        boolean l = helper(root.left, p, q);
        boolean f = helper(root.right, p, q);
        if(l && f) {
            result = root;
        }
        return l || f;
    }
}