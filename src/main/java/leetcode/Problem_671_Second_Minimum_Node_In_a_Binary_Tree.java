package leetcode;

public class Problem_671_Second_Minimum_Node_In_a_Binary_Tree {

    int min = Integer.MAX_VALUE;
    boolean found = false;
    public int findSecondMinimumValue(TreeNode root) {
        findSecondBest(root, root.val);
        return found ? min : -1;
    }

    public void findSecondBest(TreeNode root, int pVal) {
        if(root == null) {
            return;
        }
        if(root.val > pVal && root.val <= min) {
            found = true;
            min = root.val;
        }
        findSecondBest(root.left, pVal);
        findSecondBest(root.right, pVal);
    }
}

