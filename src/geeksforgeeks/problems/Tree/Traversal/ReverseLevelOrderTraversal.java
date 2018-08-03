package geeksforgeeks.problems.Tree.Traversal;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyLinkedList;
import geeksforgeeks.ds.MyLinkedStack;
import geeksforgeeks.ds.MyQueue;

public class ReverseLevelOrderTraversal {

    /**
     * Time Complexity : O(N)
     * SpaceComplexity : O(N + N)
     * https://www.youtube.com/watch?v=FfF0FubRtYs&index=4&list=PLqM7alHXFySHCXD7r1J0ky9Zg_GBB1dbk
     */

    public static void reverseLevelOrderTraversal(MyBinaryTree tree) {
        if (tree != null) {
            MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(5);
            MyLinkedStack<MyBinaryTree.Node> stack = new MyLinkedStack<>();
            queue.enQueue(tree.root);
            while (!queue.isEmpty()) {
                MyBinaryTree.Node node = queue.deQueue();
                if (node.right != null)
                    queue.enQueue(node.right);
                if (node.left != null)
                    queue.enQueue(node.left);
                stack.push(node);
            }
            while (!stack.isEmpty()) {
                System.out.print(" " + stack.pop().key);
            }
        } else {
            System.out.println("Tree is null");
        }
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.left.right = new MyBinaryTree.Node(5);
        tree.root.right.left = new MyBinaryTree.Node(6);
        tree.root.right.right = new MyBinaryTree.Node(7);

        /**           1
         *         /     \
         *       2        3
         *    /   \      /  \
         *  4      5    6    7
         */

        //This is post Order Traversal
        System.out.println("Expected : 4 5 6 7 2 3 1 ");
        reverseLevelOrderTraversal(tree);
    }
}
