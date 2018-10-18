package geeksforgeeks.problems.Tree;

import geeksforgeeks.ds.MyLinkedStack;
import geeksforgeeks.ds.MyQueue;

public class BinaryTreeUtil {

    public static class Node<T> {
        public Node left;
        public Node right;
        public T key;

        public Node(T key) {
            this.key = key;
            left = right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    /**
     * This is full binary tree.
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     */
    public static Node getBinaryTree() {
        Node root = new Node<>(8);
        root.left = new Node<>(3);
        root.right = new Node<>(5);
        root.left.left = new Node<>(3);
        root.right.right = new Node<>(5);
        return root;
    }

    /**
     * 1       1
     * /   \
     * 2     3
     * / \    / \
     * 4   5  6   7
     * / \
     * 8  9
     */
    public static Node getBinaryTree2() {
        Node root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        root.left.right.left = new Node<>(8);
        root.left.right.right = new Node<>(9);


        return root;
    }

    /**
     * This is full binary tree.
     * - 1
     * /   \
     * 2     2
     * / \   \ \
     * 3   4  4  3
     */
    public static Node getSymmetricBinaryTree() {
        Node root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(4);
        root.right.left = new Node<>(4);
        root.right.right = new Node<>(3);
        return root;
    }

    /**
     * Time Complexity : O(N) : because you are iterating over elements exactly once
     * Space complexity: O(N) : Usage of Queue
     */
    public static void levelOrderTraversal(Node root) {
        MyQueue<Node> queue = new MyQueue<>(20);

        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            System.out.println("\nLevel Order Traversal");
            queue.enQueue(root);
            while (true) {
                int numberOfNodes = queue.size();
                if (numberOfNodes <= 0) return;

                while (numberOfNodes != 0) {
                    Node node = queue.deQueue();
                    System.out.print(node.key + " ");
                    if (node.left != null)
                        queue.enQueue(node.left);
                    if (node.right != null)
                        queue.enQueue(node.right);
                    numberOfNodes--;
                }
                System.out.println();
            }
        }
    }

    public static void iterativePostOrderTraversal(Node root) {
        MyLinkedStack<Node> stack = new MyLinkedStack<>();
        MyLinkedStack<Node> stack2 = new MyLinkedStack<>();

        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            stack.push(root);
            System.out.println("\nIterative PostOrder Traversal");
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                stack2.push(node);
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().key + " ");
            }
        }
    }

    public static void iterativePreOrderTraversal(Node root) {
        MyLinkedStack<Node> stack = new MyLinkedStack<>();

        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            stack.push(root);
            System.out.println("\nIterative PreOrder Traversal");
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.key + " ");
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }

    }

    /**
     * Time Complexity : O(N)
     * SpaceComplexity : O(N + N)
     * https://www.youtube.com/watch?v=FfF0FubRtYs&index=4&list=PLqM7alHXFySHCXD7r1J0ky9Zg_GBB1dbk
     */

    public static void reverseLevelOrderTraversal(Node root) {
        if (root != null) {
            MyQueue<Node> queue = new MyQueue<>(5);
            MyLinkedStack<Node> stack = new MyLinkedStack<>();
            queue.enQueue(root);
            while (!queue.isEmpty()) {
                Node node = queue.deQueue();
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

    /*LNR*/
    public static void inOrderTraversal(Node node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.key + " ");
        inOrderTraversal(node.right);
    }

    /*NLR*/
    public static void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /*LRN*/
    public static void postOrderTraversal(Node node) {
        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.key + " ");
    }


    public static void levelOrderTraversalWithDirectionChangeAfterEachLevel(int count, Node root) {

        int numberOfNodesAtLevel;
        int changeDirectionCount = 0;
        boolean rightToLeft = false;

        MyLinkedStack<Node> stack = new MyLinkedStack();

        MyQueue<Node> queue = new MyQueue<>(20);
        queue.enQueue(root);

        while (!queue.isEmpty()) {
            changeDirectionCount++;
            numberOfNodesAtLevel = queue.size();

            for (int i = 0; i < numberOfNodesAtLevel; i++) {
                Node temp = queue.deQueue();

                if (!rightToLeft) System.out.print(temp.key + " ");
                else stack.push(temp);

                if (temp.left != null) queue.enQueue(temp.left);
                if (temp.right != null) queue.enQueue(temp.right);

            }

            if (rightToLeft) {
                while (!stack.isEmpty()) {
                    Node temp = stack.pop();
                    System.out.print(temp.key + " ");
                }
            }

            if (changeDirectionCount == count) {
                changeDirectionCount = 0;
                rightToLeft = !rightToLeft;
            }

            System.out.println();
        }
    }
}
