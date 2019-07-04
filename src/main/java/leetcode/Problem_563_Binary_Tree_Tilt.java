package leetcode;

public class Problem_563_Binary_Tree_Tilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return tilt;
    }
    public int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}