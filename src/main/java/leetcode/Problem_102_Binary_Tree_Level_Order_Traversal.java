package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_102_Binary_Tree_Level_Order_Traversal {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> gList = new ArrayList<>();

        if(root == null) {
            return gList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int size = queue.size();
        ArrayList<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
            size--;
            if(size == 0) {
                gList.add(list);
                list = new ArrayList<>();
                size = queue.size();
            }
        }
        return gList;
    }
}