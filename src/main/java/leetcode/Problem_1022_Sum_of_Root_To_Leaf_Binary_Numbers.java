package leetcode;

public class Problem_1022_Sum_of_Root_To_Leaf_Binary_Numbers {

    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return ans;
    }
    public void helper(TreeNode root, int val){
        if(root == null) return;
        val = val << 1 | root.val;
        if(root.left == null && root.right == null) ans += val;
        helper(root.left, val);
        helper(root.right, val);
    }
}