package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem59_Check_whether_a_binary_tree_is_a_full_binary_tree_or_not extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(String.valueOf(isBinaryTree(getBinaryTree2())));
    }

    static boolean isBinaryTree(Node root) {
        if (root == null) return true;

        if (root.left == null ^ root.right == null) {
            return false;
        }


        return isBinaryTree(root.left) && isBinaryTree(root.right);
    }
}

