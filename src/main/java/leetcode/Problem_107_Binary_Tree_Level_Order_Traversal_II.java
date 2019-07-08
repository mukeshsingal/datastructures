package leetcode;


import java.util.*;

public class Problem_107_Binary_Tree_Level_Order_Traversal_II{


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> gList = new ArrayList<>();

        if(root == null) {
            return gList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int size = queue.size();
        ArrayList<Integer> list = new ArrayList<>();
        //Stack<Integer> stack = new Stack<>();

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
        Collections.reverse(gList);
        return gList;
    }
}