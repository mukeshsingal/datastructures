package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

/**
 *  Half Nodes are the nodes which has only one child
 *                      2
 *                     / \
 *                    7   5
 *                   \      \
 *                   6       9
 *                  /  \     /
 *                1     11   4
 * Ans: 7 5 9
 * Hence Count is 3
 * */
public class Problem5_Count_half_nodes_in_a_Binary_tree {
    public static void count(MyBinaryTree tree) {
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(8);
        queue.enQueue(tree.root);
        int count = 0;
        while (!queue.isEmpty()) {
            MyBinaryTree.Node node = queue.deQueue();
            if ((node.left == null && node.right != null) || (node.left != null && node.right == null))
                count++;
            if (node.left != null) queue.enQueue(node.left);
            if (node.right != null) queue.enQueue(node.right);
        }
        System.out.println("Actual Answer : " + count);
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>(2);
        tree.root.left = new MyBinaryTree.Node(7);
        tree.root.right = new MyBinaryTree.Node(5);
        tree.root.left.right = new MyBinaryTree.Node(6);
        tree.root.left.right.left = new MyBinaryTree.Node(1);
        tree.root.left.right.right = new MyBinaryTree.Node(11);
        tree.root.right.right = new MyBinaryTree.Node(9);
        tree.root.right.right.left = new MyBinaryTree.Node(4);
        System.out.println("Expected Ans : " + 3);
        count(tree);
    }
}