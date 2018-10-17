package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem37_Find_Minimum_Depth_of_a_Binary_Tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node node = getBinaryTree();
        System.out.println(getMinDepth(node));
    }

    /**
     * Number of nodes from root to nearest leaf.
     */
    private static int getMinDepth(Node node) {
        if(node == null) return 0;

        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left == null)
            return getMinDepth(node.right) + 1;
        if (node.right == null)
            return getMinDepth(node.left) + 1;

        return Math.min(getMinDepth(node.left), getMinDepth(node.right)) + 1;
    }
}
