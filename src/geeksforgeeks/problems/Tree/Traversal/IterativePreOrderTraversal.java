package geeksforgeeks.problems.Tree.Traversal;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyLinkedStack;
import geeksforgeeks.ds.MyQueue;
import geeksforgeeks.ds.MyStack;

public class IterativePreOrderTraversal {
    /**
     *              1
     *            /   \
     *           2      3
     *         /      /
     *        4      5
     *  Ans : 1 2 4 3 5
     *
     *  Time Complexity : O(N) : because you are iterating over elements exactly once
     *  Space complexity: O(N) : Usage of Queue
     *
     * */
    public static void iterativePreOrderTraversal(MyBinaryTree.Node root) {
        MyLinkedStack<MyBinaryTree.Node> stack = new MyLinkedStack<>();

        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            stack.push(root);
            System.out.println("\nIterative PreOrder Traversal");
            while (!stack.isEmpty()) {
                MyBinaryTree.Node node = stack.pop();
                System.out.print(node.key + " ");
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }

    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.right.left = new MyBinaryTree.Node(5);

        iterativePreOrderTraversal(tree.root);
    }
}
