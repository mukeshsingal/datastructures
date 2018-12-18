package geeksforgeeks.problems.Tree.Youtube;

public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(new Node(20));
        bst.insert(new Node(8));
        bst.insert(new Node(22));
        bst.insert(new Node(4));
        bst.insert(new Node(12));
        bst.insert(new Node(10));
        bst.insert(new Node(14));

        //bst.print();
        int[][] testcases = {{10, 14}, {8, 14}, {10, 22}};
        for (int[] testcase : testcases) {
            Node node = findLCA(bst.root, testcase[0], testcase[1]);
            System.out.println("LCS (" + testcase[0] + ", " + testcase[1] + ")= " + String.valueOf(node.data));
        }

    }

    /*
     * Algorithm says: Look for the node where one node is in left and other in right, that node is LCA
     * else
     * 1. if current node data > both the given nodes
     *      then look into left sub tree
     * 2. else
     *      look into right sub tree
     */

    static Node findLCA(Node root, int node1, int node2) {
        while (root != null) {
            if ((node1 <= root.data && node2 >= root.data) || (node1 >= root.data && node2 <= root.data)) {
                return root;
            }

            if (node1 < root.data) {
                root = root.left;
                continue;
            }
            root = root.right;
        }
        return null;
    }
}


class BST {
    Node root;

    void print() {
        print(root);
    }

    void print(Node root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }

    void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node temp = root;
        Node prev = temp;

        while (temp != null) {
            prev = temp;
            if (temp.data < node.data) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        if (node.data < prev.data) {
            prev.left = node;
        } else {
            prev.right = node;
        }
    }
}

class Node {
    Node left;
    Node right;

    int data;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
