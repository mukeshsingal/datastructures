package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem51_Boundary_Traversal_of_binary_tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        printBoundary(getBinaryTree2());
    }

    static void printBoundary(Node node) {
        System.out.println(node);

        printBoundaryLeft(node.left);

        printBoundaryLeaves(node.left);
        printBoundaryLeaves(node.right);

        printBoundaryRight(node.right);
    }

    static void printBoundaryLeft(Node node) {
        while (node.left != null || node.right != null) {
            System.out.println(node);

            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    static void printBoundaryRight(Node node) {
        while (node.left != null || node.right != null) {
            System.out.println(node);

            if (node.right != null) node = node.right;
            else node = node.left;
        }
    }

    static void printBoundaryLeaves(Node node) {

        if (node == null) return;

        if (node.left == null && node.right == null)
            System.out.println(node);

        printBoundaryLeaves(node.left);
        printBoundaryLeaves(node.right);
    }
}
