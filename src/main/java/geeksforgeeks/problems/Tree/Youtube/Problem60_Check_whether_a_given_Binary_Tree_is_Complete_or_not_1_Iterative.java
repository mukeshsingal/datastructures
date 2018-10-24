package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Problem60_Check_whether_a_given_Binary_Tree_is_Complete_or_not_1_Iterative extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(checkIfTreeComplete(getBinaryTree()));
    }

    /* Idea is to do level order traversal */
    static boolean checkIfTreeComplete(Node node) {
        if (node == null) {
            //base case
            System.out.println("Tree doesn't have any nodes. Null is found");
            return true;
        }
        Queue<Node> binaryTreeQueue = new LinkedList<Node>();
        binaryTreeQueue.add(node);

        boolean isAllNodesComplete = true;

        while (!binaryTreeQueue.isEmpty()) {
            Node tempNode = binaryTreeQueue.remove();

            if (tempNode.left != null) {
                // this means Left node exist even after non complete node, such tree cannot be binary tree
                if (isAllNodesComplete == false) {
                    return false;
                }
                binaryTreeQueue.add(tempNode.left);
            } else {
                isAllNodesComplete = false;
            }

            if (tempNode.right != null) {
                // this means Left node exist even after non complete node, such tree cannot be binary tree
                if (isAllNodesComplete == false) {
                    return false;
                }
                binaryTreeQueue.add(tempNode.right);
            } else {
                isAllNodesComplete = false;
            }
        }

        return true;
    }
}
