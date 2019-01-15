package mustdo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public Node getTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        return root;
    }
    public  void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            System.out.println("\nLevel Order Traversal");
            queue.add(root);
            while (true) {
                int numberOfNodes = queue.size();
                if (numberOfNodes <= 0) return;
                while (numberOfNodes != 0) {
                    Node node = queue.poll();
                    System.out.print(node.key + " ");
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                    numberOfNodes--;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.levelOrderTraversal(tree.getTree());

    }
}
