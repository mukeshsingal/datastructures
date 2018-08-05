package geeksforgeeks.ds;

public class MyBinaryTree<T> {
    public Node root;

    public MyBinaryTree(T key) {
        root = new Node(key);
    }

    public MyBinaryTree() {
    }

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
            return key.toString();
        }
    }

    /*LNR*/
    public void inOrderTraversal(Node node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.key + " ");
        inOrderTraversal(node.right);
    }

    /*NLR*/
    public void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /*LRN*/
    public void postOrderTraversal(Node node) {
        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.key + " ");
    }

    public void levelOrderTraversal(Node root) {
        MyQueue<Node> queue = new MyQueue<>(10);
        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            System.out.println("\nLevel Order Traversal");
            queue.enQueue(root);
            while (!queue.isEmpty()) {
                Node node = queue.deQueue();
                System.out.print(node.key + " ");
                if (node.left != null)
                    queue.enQueue(node.left);
                if (node.right != null)
                    queue.enQueue(node.right);
            }
        }

    }

    /**
     * insert the key into the binary tree at first position available in level order.
     */
    public void insert(T key) {
        MyQueue<Node> queue = new MyQueue<>(20);
        if (root == null) {
            root = new Node(key);
        } else {
            queue.enQueue(root);
            while (!queue.isEmpty()) {
                Node node = queue.deQueue();
                if (node.left == null) {
                    node.left = new Node(key);
                    break;
                } else {
                    queue.enQueue(node.left);
                }
                if (node.right == null) {
                    node.right = new Node(key);
                    break;
                } else {
                    queue.enQueue(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.println("InOrder");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPreOrder");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nPostOrder");
        tree.postOrderTraversal(tree.root);

        tree.levelOrderTraversal(tree.root);
    }
}

