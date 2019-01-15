package mustdo.Tree;

public class LowestCommonAncestorBST extends TreeUtil {
    public static void main(String[] args) {
        Node node = findLCA(getBST(), 6, 2);
        if (node != null) {
            System.out.println("LCA is " + node.key);
        } else {
            System.out.println("LCA Doesn't exist");
        }
    }

    static Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if ((root.key >= n1 && root.key <= n2) || (root.key <= n1 && root.key >= n2)) {
            return root;
        }

        if (root.key < n1 && root.key < n2) {
            return findLCA(root.right, n1, n2);
        }
        if (root.key > n1 && root.key > n2) {
            return findLCA(root.left, n1, n2);
        }
        return null;
    }
}
