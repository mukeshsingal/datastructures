package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.ds.MyQueue;
import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;


/**
 *  Full Nodes are the nodes which has both left and right children.
 *                      2
 *                     / \
 *                    7   5
 *                   \      \
 *                   6       9
 *                  /  \     /
 *                1     11   4
 * Ans: 1 11 9
 * Hence Count is 3
 * */
public class Problem7_Iterative_method_to_Count_full_nodes_in_a_Binary_tree extends BinaryTreeUtil {
    public static void count(Node root) {
        MyQueue<Node> queue = new MyQueue<>(8);
        queue.enQueue(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.deQueue();
            if (node.left != null && node.right != null)
                count++;
            if (node.left != null) queue.enQueue(node.left);
            if (node.right != null) queue.enQueue(node.right);
        }
        System.out.println("Actual Answer : " + count);
    }

    public static void main(String[] args) {
        System.out.println("Expected Ans : " + 2);
        Node root1 = getBinaryTree();
        count(root1);
    }
}
