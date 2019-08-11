package leetcode;

public class Problem_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    private int rootIdx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        rootIdx = 0;
        return bstFromPreorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorderHelper(int[] preorder, int min, int max) {
        if (rootIdx >= preorder.length) {
            return null;
        }

        int rootValue = preorder[rootIdx];
        if (rootValue < min || rootValue > max) {
            return null;
        }

        TreeNode root = new TreeNode(rootValue);
        ++rootIdx;
        root.left = bstFromPreorderHelper(preorder, min, rootValue);
        root.right = bstFromPreorderHelper(preorder, rootValue, max);
        return root;
    }
}