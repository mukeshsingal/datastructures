package leetcode;

public class Problem_965_Univalued_Binary_Tree {
    public boolean isUnivalTree(TreeNode root) {
        boolean result = true;
        if (root == null) {
            return true;
        }
        if (root.left != null)
            result = root.val == root.left.val;
        if (root.right != null)
            result = result & (root.val == root.right.val);

        return result && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
