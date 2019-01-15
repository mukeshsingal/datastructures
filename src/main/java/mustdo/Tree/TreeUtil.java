package mustdo.Tree;

public class TreeUtil {
    static class Node {
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    /**
     * This is full binary tree.
     *    5
     *  /   \
     * 3     7
     * / \   /
     *2   4 6
     */
    public static Node getBST() {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);
        return root;
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
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);


        return root;
    }
                /*     20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \
                  10    14*/
    public  static Node getBianryTreeThree(){
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(25);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
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
