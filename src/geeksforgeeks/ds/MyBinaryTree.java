package geeksforgeeks.ds;

public class MyBinaryTree<T> {
    public Node root;

    public MyBinaryTree(T key) {
        root = new Node<>(key);
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



    /**
     * Algorithm
     * 1. Starting at root, find the deepest and rightmost node in binary tree and node which we want to delete.
     * 2. Replace the deepest rightmost node’s data with node to be deleted.
     * 3. Then delete the deepest rightmost node.
     */
    public void delete(T key) {
        System.out.println("Deleting key " + key);
        if (root == null) {
            System.out.println("Nothing can be deleted");
        } else {

            MyQueue<Node> queue = new MyQueue<>(20);
            queue.enQueue(root);

            Node keyNode = null;
            Node lastNode = null;

            while (!queue.isEmpty()) {
                lastNode = queue.deQueue();
                if (lastNode.key == key) {
                    keyNode = lastNode;
                }
                if (lastNode.left != null) {
                    queue.enQueue(lastNode.left);
                }
                if (lastNode.right != null) {
                    queue.enQueue(lastNode.right);
                }
            }
            if (keyNode == null) {
                System.out.println("Element Node Found");
            } else {
                keyNode.key = lastNode.key;
            }

            deleteDeepestNode(lastNode);
        }
    }

    private void deleteDeepestNode(Node lastNode) {
        MyQueue<Node> queue = new MyQueue<>(20);
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.deQueue();
            if (node.left == lastNode) {
                node.left = null;
            }
            if (node.right == lastNode) {
                node.right = null;
            }
            if (node.left != null) {
                queue.enQueue(node.left);
            }
            if (node.right != null) {
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
            root = new Node<>(key);
        } else {
            queue.enQueue(root);
            while (!queue.isEmpty()) {
                Node node = queue.deQueue();
                if (node.left == null) {
                    node.left = new Node<>(key);
                    break;
                } else {
                    queue.enQueue(node.left);
                }
                if (node.right == null) {
                    node.right = new Node<>(key);
                    break;
                } else {
                    queue.enQueue(node.right);
                }
            }
        }
    }

    /**
     * Width of a tree is maximum of widths of all levels.
     *           1
     *         /  \
     *        2    3
     *      /  \     \
     *     4    5     8
     *               /  \
     *              6    7
     *
     * width of level 1 is 1,
     * width of level 2 is 2,
     * width of level 3 is 3
     * width of level 4 is 2.
     */
    public int width() {
        MyQueue<MyBinaryTree.Node> newQueue = new MyQueue<>(20);
        newQueue.enQueue(root);
        int width = 0;
        while (true) {
            int nodeCount = newQueue.size();

            if (nodeCount <= 0) {
                return width;
            }
            if (nodeCount > width) {
                width = nodeCount;
            }
            while (nodeCount > 0) {
                Node node = newQueue.deQueue();
                if (node.left != null) {
                    newQueue.enQueue(node.left);
                }
                if (node.right != null) {
                    newQueue.enQueue(node.right);
                }
                nodeCount--;
            }
        }

    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);


        /*          1
         *          / \
         *         2   3
         *       /  \
         *      4    5
         * */

        //tree.delete(2);
        System.out.println("Width of tree is " + tree.width());
        /*System.out.println("InOrder");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPreOrder");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nPostOrder");
        tree.postOrderTraversal(tree.root);*/
    }
}

