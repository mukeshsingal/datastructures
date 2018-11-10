package geeksforgeeks.ds.trees;


import java.util.Optional;

/*TODO: Inseration and Deletion not yet completed. */
public class RedBlackTree {

    public enum Color {
        RED,
        BLACK
    }

    class Node {
        int data;
        Color color;
        Node left, right;
        Node parent;
        boolean isNullLeaf;

        Node(int data, Color color) {
            this.color = color;
            this.data = data;
        }
        Node() { }
    }

    public Node createBlackNode(int data) {
        Node node = new Node(data, Color.BLACK);
        node.left = createNullLeafNode(node);
        node.right = createNullLeafNode(node);
        return node;
    }
    public Node createRedNode(int data) {
        Node node = new Node(data, Color.RED);
        node.left = createNullLeafNode(node);
        node.right = createNullLeafNode(node);
        return node;
    }

    public Node createNullLeafNode(Node parent) {
        Node leaf = new Node();
        leaf.color = Color.BLACK;
        leaf.isNullLeaf = true;
        leaf.parent = parent;
        return leaf;
    }

    public Node insert(Node root, int data) {
        return insert(null, root, data);
    }

    private Node insert(Node parent, Node root, int data) {
        if (root == null || root.isNullLeaf) {
            if (parent != null) {
                return createRedNode(data);
            }
            else{
                createBlackNode(data);
            }
        }

        boolean isLeft;

        if (root.data > data) {
            Node left = insert(root, root.left, data);
            if(left == root.parent) return left;
            root.left = left;
            isLeft = true;
        }
        else{
            Node right = insert(root, root.right, data);
            if(right == root.parent) return right;
            root.right = right;
            isLeft = false;
        }

        if(isLeft) {
            if(root.color == Color.RED && root.left.color == Color.RED) {
                Optional<Node> sibling = findSiblingNode(root);

                if(!sibling.isPresent() || sibling.get().color == Color.BLACK){
                    if(isLeftChild(root)) {
                        rightRotate(root, true);
                    }
                }
            }
        }

        return root;
    }


    private void rightRotate(Node root, boolean changeColor) {
        Node parent = root.parent;
        root.parent = parent.parent;

    }
    private Optional<Node> findSiblingNode(Node root) {
        Node parent = root.parent;
        if(isLeftChild(root)) {
            return Optional.ofNullable(parent.right.isNullLeaf ? null : parent.right);
        }
        else {
            return Optional.ofNullable(parent.left.isNullLeaf ? null : parent.left);
        }
    }

    private boolean isLeftChild(Node root) {
        Node parent = root.parent;
        return (parent.left == root);
    }

    public void print(Node root) {
        printRedBlackTree(root, 0);
    }

    private void printRedBlackTree(Node root, int space) {
        if (root == null || root.isNullLeaf) {
            return;
        }
        printRedBlackTree(root.right, space + 5);
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.data + " " + (root.color == Color.BLACK ? "B" : "R"));
        printRedBlackTree(root.left, space + 5);
    }

    public static void main(String[] args) {
        Node root = null;
        RedBlackTree redBlackTree = new RedBlackTree();

        root = redBlackTree.insert(root, 10);
        root = redBlackTree.insert(root, 12);
        root = redBlackTree.insert(root, 13);
        root = redBlackTree.insert(root, 14);
    }
}
