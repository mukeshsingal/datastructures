package geeksforgeeks.ds;

public class MyBinaryTree<T> {
    public Node root;

    public MyBinaryTree(T key) {
        root = new Node(key);
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

    public void levelOrderTraversal() {
        MyQueue<Node> queue = new MyQueue<>(10);
        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            System.out.println("\nLevel Order Traversal");
            queue.enQueue(root);
            while (!queue.isEmpty()){
                Node node = queue.deQueue();
                System.out.print (node.key + " ");
                if(node.left !=null )
                    queue.enQueue(node.left);
                if(node.right!=null)
                    queue.enQueue(node.right);
            }
        }

    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.right.left = new MyBinaryTree.Node(5);

        System.out.println("InOrder");
        tree.inOrderTraversal(tree.root);
        System.out.println("\nPreOrder");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nPostOrder");
        tree.postOrderTraversal(tree.root);

        tree.levelOrderTraversal();
    }
}

