package leetcode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Problem_572_Subtree_of_Another_Tree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        if(s.val == t.val) {
            if(isSubtreeSub(s,t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSubtreeSub(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if((s != null && t == null) || (s == null && t != null)) {
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSubtreeSub(s.left, t.left) && isSubtreeSub(s.right, t.right);
    }
}