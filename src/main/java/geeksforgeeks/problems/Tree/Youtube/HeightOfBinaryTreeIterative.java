package geeksforgeeks.problems.Tree.Youtube;

import ds.trees.MyBinaryTree;
import ds.Queue.MyQueue;

/**
 * Thre are two conventions to define height of binary tree.
 *
 * 1) Number of nodes on longest path from root to deepest node
 * 2) Number of edges on longest Path from root to the deepest node
 *          1
 *         / \
 *        2   3
 *       / \
 *      4  5   Ans: 3  : 1-2-4
 *
 * */
public class HeightOfBinaryTreeIterative {

    public static int getHeight(MyBinaryTree tree){
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(20);
        queue.enQueue(tree.root);
        int height = 0;
        while (true) {
            int nodeCount = queue.size();
            if(nodeCount <= 0)
                return height;
            height ++;
            while (nodeCount>0) {
                MyBinaryTree.Node node = queue.deQueue();
                if (node.left != null) {
                    queue.enQueue(node.left);
                }
                if (node.right != null) {
                    queue.enQueue(node.right);
                }
                nodeCount--;
            }

        }
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
        System.out.println("Height of Tree is " + getHeight(tree));

        /**
         *                    2
         *                 /    \
         *               7        5
         *               \          \
         *                6           9
         *               /  \         /
         *              1   11       4
         *
         * So height is : 4
         * */

    }
}
