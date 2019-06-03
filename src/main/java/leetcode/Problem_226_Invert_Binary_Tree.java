package leetcode;

public class Problem_226_Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if(root== null )
            return null;
        if(root.left == null && root.right == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        return root;
    }
}