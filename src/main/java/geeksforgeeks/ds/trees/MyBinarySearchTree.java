package geeksforgeeks.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {

    private static Node root;

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }


    void insert(int data) {
        root = insertUtil(root, data);
    }

    private Node insertUtil(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data >= data) {
            root.left = insertUtil(root.left, data);
        } else {
            root.right = insertUtil(root.right, data);
        }
        return root;
    }

    public Node search(int data) { return search(root, data); }

    private Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data > data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }

    private Node delete(int data) {
        return deleteNode(root, data);
    }

    private Node deleteNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data > data) {
            node.left = deleteNode(node.left, data);
        } else if (node.data < data)
            node.right = deleteNode(node.right, data);
        else {
            /* Delete Element with no child */
            if (node.left != null && node.right != null) {
                Node inOrderSuccessor = findInOrderSuccessor(node.right);
                node.data = inOrderSuccessor.data;
                node.right = deleteNode(node.right, inOrderSuccessor.data);
            }
            /* Delete Element with Single Child  */
            else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else
                node = null;
        }
        return node;
    }


    public Node findInOrderSuccessor(Node node) {
        if (node.left == null)
            return node;
        else
            return findInOrderSuccessor(node.left);
    }

    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();

        /*       50
         *      /  \
         *     30   70
         *    / \    / \
         *   20 40  60  80
         */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        String x = "" +
                "              50\n" +
                "           /     \\\n" +
                "          30      70\n" +
                "         /  \\    /  \\\n" +
                "       20   40  60   80";

        System.out.println(x);
        System.out.println(tree);
        System.out.println("Search for 60 -> " + tree.search(80));
        tree.delete(70);
        System.out.println(tree);
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
