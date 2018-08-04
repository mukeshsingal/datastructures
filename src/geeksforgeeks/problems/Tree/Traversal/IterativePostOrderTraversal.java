package geeksforgeeks.problems.Tree.Traversal;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyLinkedStack;


/**
 *                1
 *              /   \
 *            2      3
 *           /      / \
 *          4      5   6
 * Ans : 4 2  5 3 1
 *
 * Stack 1 :
 * Stack 2:  1 3
 * <p>
 * Time Complexity : O(N) : because you are iterating over elements exactly once
 * Space complexity: O(N) : Usage of Queue
 */

public class IterativePostOrderTraversal {
    public static void iterativePostOrderTraversal(MyBinaryTree.Node root) {
        MyLinkedStack<MyBinaryTree.Node> stack = new MyLinkedStack<>();
        MyLinkedStack<MyBinaryTree.Node> stack2 = new MyLinkedStack<>();

        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            stack.push(root);
            System.out.println("\nIterative PostOrder Traversal");
            while (!stack.isEmpty()) {
                MyBinaryTree.Node node = stack.pop();
                stack2.push(node);
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().key + " " );
            }
        }

    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.right.left = new MyBinaryTree.Node(5);
        tree.root.right.right = new MyBinaryTree.Node(6);

        iterativePostOrderTraversal(tree.root);
    }
}
