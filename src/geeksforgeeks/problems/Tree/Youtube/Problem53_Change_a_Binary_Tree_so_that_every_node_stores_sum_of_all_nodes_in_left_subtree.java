package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem53_Change_a_Binary_Tree_so_that_every_node_stores_sum_of_all_nodes_in_left_subtree extends BinaryTreeUtil {

    public static void main(String[] args) {

        levelOrderTraversal(modifyBinaryTree(getBinaryTree()));
    }

    static Node modifyBinaryTree(Node node) {
        modifyBinaryTreeUtil(node);
        return node;
    }

    static int modifyBinaryTreeUtil(Node<Integer> node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return node.key;
        }

        int leftSum = modifyBinaryTreeUtil(node.left);
        int rightSum = modifyBinaryTreeUtil(node.right);

        node.key += leftSum;

        return node.key + rightSum;
    }

}
