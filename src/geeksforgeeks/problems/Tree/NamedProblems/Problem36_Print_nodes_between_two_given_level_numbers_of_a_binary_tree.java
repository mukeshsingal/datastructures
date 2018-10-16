package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyLinkedStack;
import geeksforgeeks.ds.MyQueue;
import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem36_Print_nodes_between_two_given_level_numbers_of_a_binary_tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node node = getBinaryTree();

        printLevel(1, 3, node);
    }

    public static void printLevel(int lowLevel, int highLevel, Node root) {

        int numberOfNodesAtLevel;
        int levelCount = 0;
        MyQueue<Node> queue = new MyQueue<>(20);
        queue.enQueue(root);

        while (!queue.isEmpty()) {

            numberOfNodesAtLevel = queue.size();
            levelCount++;

            for (int i = 0; i < numberOfNodesAtLevel; i++) {
                Node temp = queue.deQueue();

                if (temp.left != null) queue.enQueue(temp.left);
                if (temp.right != null) queue.enQueue(temp.right);

                if(levelCount >= lowLevel && levelCount <= highLevel)
                    System.out.print(temp.key + " ");
            }
            System.out.println();
        }
    }
}
