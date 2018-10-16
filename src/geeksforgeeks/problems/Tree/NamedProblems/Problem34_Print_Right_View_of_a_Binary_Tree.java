package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyQueue;
import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem34_Print_Right_View_of_a_Binary_Tree extends BinaryTreeUtil {

    public static void main(String[] args) {
        Node node = getBinaryTree();
        getRightViewOfBinaryTree(node);
    }

    public static void getRightViewOfBinaryTree(Node root) {
        MyQueue<Node> queue = new MyQueue<>(20);
        queue.enQueue(root);

        while (!queue.isEmpty()) {
            int nodeInCurrentLevel = queue.size();

            for (int i = 0; i < nodeInCurrentLevel; i++) {
                Node node = queue.deQueue();
                if(i == nodeInCurrentLevel -1) {
                    System.out.println(node.key);
                }

                if (node.left != null) queue.enQueue(node.left);
                if (node.right != null) queue.enQueue(node.right);
            }
        }
    }
}
