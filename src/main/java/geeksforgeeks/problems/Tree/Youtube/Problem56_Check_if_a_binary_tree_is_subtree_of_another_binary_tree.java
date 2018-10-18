package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem56_Check_if_a_binary_tree_is_subtree_of_another_binary_tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(isSubTree(getBinaryTree2(), getBinaryTree()));
    }

    static boolean isSubTree(Node<Integer> sourceTreeRoot, Node<Integer> matchTreeRoot) {
        if (matchTreeRoot == null) {
            return true;
        }

        if (sourceTreeRoot == null) {
            return false;
        }

        if (areIdentical(sourceTreeRoot, matchTreeRoot)) return true;

        return isSubTree(sourceTreeRoot.left, matchTreeRoot) || isSubTree(sourceTreeRoot.right, matchTreeRoot);
    }

    static boolean areIdentical(Node<Integer> sourceTreeRoot, Node<Integer> matchTreeRoot) {
        if (sourceTreeRoot == null && matchTreeRoot == null) {
            return true;
        }

        if (sourceTreeRoot == null || matchTreeRoot == null) {
            return false;
        }

        return sourceTreeRoot.key == matchTreeRoot.key &&
                areIdentical(sourceTreeRoot.left, matchTreeRoot.left) &&
                areIdentical(sourceTreeRoot.right, matchTreeRoot.right);
    }
}
