package leetcode;

import java.util.LinkedList;
import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class Problem_107_Binary_Tree_Level_Order_Traversal_II{

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size = queue.size();

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);

            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);

            size--;

            if(size == 0) {
                result.add(0, list);
                list = new ArrayList<>();
                size = queue.size();
            }
        }

        return result;
    }
}