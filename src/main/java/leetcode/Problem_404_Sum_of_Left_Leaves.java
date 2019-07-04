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
public class Problem_404_Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, 'R');
    }
    public int sumOfLeftLeaves(TreeNode root, char dir) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null && dir == 'L') {
            return root.val;
        }
        if(root.left == null && root.right == null && dir == 'R') {
            return 0;
        }

        return sumOfLeftLeaves(root.left, 'L') + sumOfLeftLeaves(root.right, 'R');
    }
}