package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IterativeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return list;
        else stack.push(root);

        while (!stack.empty()) {
            TreeNode current = stack.peek();
            if(current.left != null) {
                stack.push(current.left);
                continue;
            }
            list.add(current.val);
            stack.pop();
            if(current.right!=null) {
                stack.push(current.right);
            }
            else{
                while(!stack.empty()) {
                    current = stack.pop();
                    list.add(current.val);
                    if (current.right != null) {
                        stack.push(current.right);
                        break;
                    }
                }
            }
        }
        return list;
    }
}