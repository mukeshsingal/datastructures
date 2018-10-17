package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem39_Print_nodes_at_k_distance_from_root extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node node = getBinaryTree();
        printNodesAtDistance(node, 0);
    }

    public static void printNodesAtDistance(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.println(node.key);
        } else {
            printNodesAtDistance(node.left, k - 1);
            printNodesAtDistance(node.right, k - 1);
        }
    }
}
