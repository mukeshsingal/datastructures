package mustdo.Tree;

public class TreeUtil {
    static class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        return root;
    }

    /**
     * 1
     * /   \
     * 2     3
     * / \    / \
     * 4   5  6   7
     * / \
     * 8  9
     */
    public static Node getBinaryTree2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);


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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        return root;
    }
}
