package geeksforgeeks.ds;


public class MyBinarySearchTree extends MyBinaryTree<Integer> {
    private static MyBinaryTree.Node<Integer> root;

    public MyBinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRecord(root, key);
    }

    Node insertRecord(MyBinaryTree.Node<Integer> node, int key) {
        if (node == null) {
            node = new MyBinaryTree.Node<Integer>(key);
            return node;
        } else {
            if (key < (int) node.key) {
                node.left = insertRecord(node.left, key);
            } else if (key > (int) node.key) {
                node.right = insertRecord(node.right, key);
            }
        }
        return node;
    }

    static boolean searchUsingIteration(int key) {
        Node node = root;
        while (node != null) {
            if ((int)node.key < key)
                node = node.right;
            else if ((int)node.key > key)
                node = node.left;
            else
                return true;
        }
        return false;
    }

    static Node searchUsingRecursion(Node node, int key) {

        if(node == null || (int)node.key == key) {
            return node;
        }
        else{
            if ((int)node.key < key)
                return searchUsingRecursion(node.right, key);
            if ((int)node.key > key)
                return searchUsingRecursion(node.left, key);
        }
        return null;
    }


    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
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
        tree.levelOrderTraversal(root);
    }
}
