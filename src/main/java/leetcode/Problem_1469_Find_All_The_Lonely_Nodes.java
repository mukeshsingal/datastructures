package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Problem_1469_Find_All_The_Lonely_Nodes {
 
    public List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        getLonelyNodesHelper(root, result);

        return result;

    }

    private void getLonelyNodesHelper(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        if(root.left != null && root.right != null) {
            getLonelyNodesHelper(root.left, result);
            getLonelyNodesHelper(root.right, result);
        }
        else if(root.left != null) {
            result.add(root.left.val);
            getLonelyNodesHelper(root.left, result);
        }
        else if(root.right != null) {
            result.add(root.right.val);
            getLonelyNodesHelper(root.right, result);
        }
    }
}


