package leetcode;

public class Problem_98_Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValid(TreeNode root, long max, long min) {
        return root == null ||
                (min<root.val && max>root.val &&
                        isValid(root.left, root.val, min)
                        &&
                        isValid(root.right, max, root.val));
    }
}
