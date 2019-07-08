package leetcode;

import java.util.ArrayList;

public class Problem_173_Binary_Search_Tree_Iterator {


    ArrayList<Integer> nums;
    int index = -1;
    public Problem_173_Binary_Search_Tree_Iterator(TreeNode root) {
        nums = new ArrayList<>();
        doInOrder(root);
        index = 0;
    }

    public void doInOrder(TreeNode node) {
        if(node == null) return;
        doInOrder(node.left);
        nums.add(node.val);
        doInOrder(node.right);
    }
    /** @return the next smallest number */
    public int next() {
        if(index < nums.size()){
            return nums.get(index++);
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < nums.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */