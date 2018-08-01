package geeksforgeeks.ds;

public class MyBinaryTree<T> {
    Node root;

    MyBinaryTree(T key) {
        root = new Node(key);
    }

    public static class Node<T> {
        Node left, right;
        T key;

        Node(T key) {
            this.key = key;
            left = right = null;
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

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.left.right = new MyBinaryTree.Node(5);

        System.out.println("InOrder");
        tree.inOrderTraversal(tree.root);
        System.out.println("\nPreOrder");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nPostOrder");
        tree.postOrderTraversal(tree.root);
    }
}

