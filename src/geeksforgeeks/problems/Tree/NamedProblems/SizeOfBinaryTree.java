package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

public class SizeOfBinaryTree {

    /**
     *  Time Complexity : O(N) : because you are iterating over elements exactly once
     *  Space complexity: O(N) : Usage of Queue
     *
     * */
    public static int sizeOfBinaryTree(MyBinaryTree.Node root) {
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(10);
        if (root == null) {
            return 0;
        } else {
            int size = 0;
            queue.enQueue(root);
            while (!queue.isEmpty()) {
                MyBinaryTree.Node node = queue.deQueue();
                size++;
                if (node.left != null)
                    queue.enQueue(node.left);
                if (node.right != null)
                    queue.enQueue(node.right);
            }
            return size;
        }

    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        //tree.root.right.left = new MyBinaryTree.Node(5);

        System.out.println(sizeOfBinaryTree(tree.root));
    }
}
