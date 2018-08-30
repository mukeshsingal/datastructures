package leetcode;

import java.util.Stack;

public class Problem_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int index = 0;
        for (int i = 1; i < pre.length; i++) {
            TreeNode cur = stack.peek();
            if (cur.val != in[index]) {
                cur.left = new TreeNode(pre[i]);
                stack.push(cur.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == in[index]) {
                    cur = stack.pop();
                    index++;
                }
                cur.right = new TreeNode(pre[i]);
                stack.push(cur.right);
            }
        }
        return root;
    }
}