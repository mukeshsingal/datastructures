package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    Node root;

    class Node {
        int data;
        int height;

        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    /*
     * Rotate right tree with root X
     *   4 (X)         5 (y)
     *    \           / \
     *    5 (Y)  (X)4   6
     *   / \         \
     *  (Z)  6        (z)
     */
    Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /* Rotate right tree with root X
     *       8 (X) |      5 (y)
     *     /       |     / \
     *    5 (Y)    |    2    8(X)
     *   / \       |        /
     *  2   (Z)    |      (z)
     */
    Node rightRotate(Node x) {
        Node y = x.left;

        x.left = y.right;
        y.right = x;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalanceFactory(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }


    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (node.data > key)
            node.left = insert(node.left, key);
        else if (node.data < key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balanceFactor = getBalanceFactory(node);

        // LL
        if (balanceFactor > 1 && key < node.left.data) {
            return rightRotate(node);
        }
        // LR
        if (balanceFactor > 1 && key > node.left.data) {
            node.left = leftRotate(node);
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && key > node.right.data) {
            return leftRotate(node);
        }
        // RL
        if (balanceFactor < -1 && key < node.right.data) {
            node.right = rightRotate(node);
            return leftRotate(node);
        }
        return node;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.root = avlTree.insert(5);
        avlTree.root = avlTree.insert(6);
        avlTree.root = avlTree.insert(7);
        avlTree.root = avlTree.insert(8);
        avlTree.root = avlTree.insert(9);
        System.out.println(avlTree);
    }

    private Node insert(int i) {
        return insert(root, i);
    }

    @Override
    public String toString() {
        if (root == null)
            return "";

        //DO level Order Traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        String traversal = "";
        int nodeInLevel = 1;

        while (!queue.isEmpty()) {
            if (nodeInLevel == 0) {
                nodeInLevel = queue.size();
                traversal += "\n";
            }
            Node node = queue.remove();
            traversal += node.data + "  ";

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            nodeInLevel--;
        }
        return traversal;
    }
}
