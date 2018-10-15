package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

import java.util.Queue;

public class PrintLeftmostAndRightmostNodesOfABinaryTree {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>(1);

        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.left.right = new MyBinaryTree.Node(5);
        tree.root.right.left = new MyBinaryTree.Node(6);
        tree.root.right.right = new MyBinaryTree.Node(7);
        tree.root.left.left.left = new MyBinaryTree.Node(8);

        LevelOrderTraversal(tree.root);
    }

    public static void LevelOrderTraversal(MyBinaryTree.Node root) {
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(20);
        queue.enQueue(root);

        int counter = 0;

        while (true) {
            int nodeCount = queue.size();
            int count= nodeCount;

            while (nodeCount > 0) {
                MyBinaryTree.Node node = queue.deQueue();
                if(nodeCount == 1 || nodeCount == count){
                    System.out.println(node.key);
                }

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
}

