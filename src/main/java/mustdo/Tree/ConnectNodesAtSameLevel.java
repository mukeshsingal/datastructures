package mustdo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    static class Node {
        Node left;
        Node right;
        Node horizontal;
        int key;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    public static void main(String[] args) {
        Node root = getBinaryTree();
        connectNodes(root);
        doPreOrder(root);
    }

    static void doPreOrder(Node root2) {
        Node root = root2;
        while (root != null) {
            Node temp = root;
            while (temp != null) {
                System.out.print(temp.key +  " -> ");
                temp = temp.horizontal;
            }
            System.out.println();
            root = root.left;
        }
    }


    public static void connectNodes(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node prev = null;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i =0; i < size; i++) {
                Node node = queue.poll();

                if(prev != null) {
                    prev.horizontal = node;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                prev = node;
            }
            prev = null;
        }
    }

    public static Node getBinaryTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right= new Node(7);
        return root;
    }
}
