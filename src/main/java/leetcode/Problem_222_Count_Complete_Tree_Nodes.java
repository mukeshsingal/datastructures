package leetcode;

public class Problem_222_Count_Complete_Tree_Nodes {



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right ==null) {
            return 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}