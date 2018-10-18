package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.ds.MyQueue;
import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem9_Check_if_two_binary_trees_are_identical_Iterative extends BinaryTreeUtil {

    public static void main(String[] args) {
        Node root1 = getBinaryTree();
        Node root2 = getBinaryTree();

        if (isIdentical(root1, root2)) {
            System.out.println("Tree are identical");
        } else {
            System.out.println("Tree aren't identical");
        }
    }

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null ^ root2 == null) {
            return false;
        }

        MyQueue<Node> queue1 = new MyQueue<>(20);
        MyQueue<Node> queue2 = new MyQueue<>(20);

        queue1.enQueue(root1);
        queue2.enQueue(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Node node1 = queue1.deQueue();
            Node node2 = queue2.deQueue();

            if (node1.key != node2.key) {
                return false;
            }

            if ((checkForNull(node1.left) && checkForNull(node2.left))) {
                queue1.enQueue(node1.left);
                queue2.enQueue(node2.left);
            } else if (checkForNull(node1.left) || checkForNull(node2.left)) {
                return false;
            }
            if ((checkForNull(node1.right) && checkForNull(node2.right))) {
                queue1.enQueue(node1.right);
                queue2.enQueue(node2.right);
            } else if (checkForNull(node1.right) || checkForNull(node2.right)) {
                return false;
            }

        }

        return true;
    }

    public static boolean checkForNull(Object object) {
        return object != null;
    }
}
