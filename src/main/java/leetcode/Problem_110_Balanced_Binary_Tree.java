package leetcode;

//https://leetcode.com/problems/balanced-binary-tree/
public class Problem_110_Balanced_Binary_Tree {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        isBalancedUtil(root);
        return balanced;
    }
    public int isBalancedUtil(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int left = isBalancedUtil(root.left);
        int right = isBalancedUtil(root.right);


        balanced = balanced && (Math.abs(left - right) <= 1);
        //System.out.println(root.val + " " + balanced);
        return 1 + Math.max(left, right);
    }
}
