package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Problem_515_Find_Largest_Value_in_Each_Tre_Row {

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        int queueSize = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            queueSize--;
            if(max < node.val) {
                max = node.val;
            }
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(queueSize == 0) {
                result.add(max);
                queueSize = queue.size();
                max = Integer.MIN_VALUE;
            }
        }
        return result;
    }
}