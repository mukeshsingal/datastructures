package leetcode;

public class Problem_1026_Maximum_Difference_Between_Node_and_Ancestor {

    int result = -1;

    public int maxAncestorDiff(TreeNode root) {
        maxHelper(root, root.val, root.val);
        return result;
    }

    public void maxHelper(TreeNode root, int min, int max) {
        if(root == null) {
            return;
        }
        int tempResult = Math.max(Math.abs(root.val - min), Math.abs(max - root.val));
        result = result < tempResult ? tempResult :result;

        int minVal = Math.min(min, root.val);
        int maxVal = Math.max(max, root.val);

        maxHelper(root.left, minVal, maxVal);
        maxHelper(root.right,minVal, maxVal);
    }
}

