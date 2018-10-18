package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem55_Check_for_Symmetric_Binary_Tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(checkSymmetric(getBinaryTree()));
    }

    static boolean checkSymmetric(Node<Integer> node) {
        return helper(node.left, node.right);
    }

    static boolean helper(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1.left == null ^ node2.right == null) {
            return false;
        }

        return node1.key == node2.key && (helper(node1.left, node2.right) && helper(node1.right, node2.left));

    }
}
