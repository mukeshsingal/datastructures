package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem40_Print_all_nodes_that_dont_have_sibling extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node node = getBinaryTree();
        printNodesWithSiblings(node);
    }

    public static void printNodesWithSiblings(Node node) {
        if (node == null)
            return;

        if (node.left != null && node.right != null) {
            printNodesWithSiblings(node.left);
            printNodesWithSiblings(node.right);
        } else if (node.left != null) {
            System.out.println(node.left);
            printNodesWithSiblings(node.left);
        } else if (node.right != null) {
            System.out.println(node.right);
            printNodesWithSiblings(node.right);
        }
    }
}
