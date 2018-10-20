package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem58_Check_if_removing_an_edge_can_divide_a_Binary_Tree_in_two_halves extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node root = getBinaryTree();
        System.out.println(checkIfDivideInEqualHalf(root, getSizeOfTree(root)));
    }

    static boolean checkIfDivideInEqualHalf(Node node, int treeSize) {

        if (node == null) {
            return false;
        }

        int leftSize = getSizeOfTree(node);

        if (leftSize == treeSize - leftSize) {
            System.out.println(String.valueOf(node));
            return true;
        }

        return checkIfDivideInEqualHalf(node.left, treeSize) || checkIfDivideInEqualHalf(node.right, treeSize);
    }

    static int getSizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + getSizeOfTree(root.left) + getSizeOfTree(root.right);
    }
}
