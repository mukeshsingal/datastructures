package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_199_Binary_Tree_Right_Side_View {
    
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;

        queue.add(root);

        int nodeCount = 1;
        int count = queue.size();

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

            count--;
            if(count == 0) {
                result.add(new Integer(node.val));
                count = queue.size();
            }
        }
        return result;
    }
}