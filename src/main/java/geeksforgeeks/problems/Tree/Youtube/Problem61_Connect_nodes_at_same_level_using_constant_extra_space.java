package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem61_Connect_nodes_at_same_level_using_constant_extra_space extends BinaryTreeUtil {
    public static void main(String[] args) {
        getSameLevelNodeConnected(getModifiedTree());
        System.out.println();
    }

    static void getSameLevelNodeConnected(TreeNode root) {
        /*do level order traversal and check if */
    }

    static TreeNode getModifiedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        return root;
    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    TreeNode nextRight;

    TreeNode(int key) {
        this.key = key;
    }
}
