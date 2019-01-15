package mustdo.Tree;

public class MaximumPathSumBetweenTwoLeaves extends TreeUtil {
    public static void main(String[] args) {
        Res result = new Res();
        result.val = Integer.MIN_VALUE;
        getMaximumPathSum(getBinaryTree(), result);
        System.out.println(result.val);
    }

    static class Res {
        int val;
    }

    private static int getMaximumPathSum(Node root, Res result) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return root.key;
        }
        int leftMax = getMaximumPathSum(root.left, result);
        int rightMax = getMaximumPathSum(root.right, result);

        if (root.left != null && root.right != null) {
            // Update result if needed
            result.val = Math.max(result.val, leftMax + rightMax + root.key);
            return Math.max(leftMax, rightMax) + root.key;
        }

        return root.left == null ? rightMax + root.key : leftMax + root.key;
    }
}
