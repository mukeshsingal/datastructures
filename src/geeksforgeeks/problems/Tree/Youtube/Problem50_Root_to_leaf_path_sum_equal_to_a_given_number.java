package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem50_Root_to_leaf_path_sum_equal_to_a_given_number extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node<Integer> node = getBinaryTree();

        printAncestor(node, 9, 0);
    }

    public static boolean printAncestor(Node<Integer> root, int key, int sum) {
        if (root == null)
            return false;

        sum += root.key;

        if (sum == key) {
            System.out.println(root);
            return true;
        }

        if (printAncestor(root.left, key, sum) || printAncestor(root.right, key, sum)) {
            System.out.println(root);
            return true;
        }

        return false;
    }
}
