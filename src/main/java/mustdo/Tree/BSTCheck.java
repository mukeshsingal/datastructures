package mustdo.Tree;

public class BSTCheck extends TreeUtil {

    public static void main(String[] args) {
        System.out.println(isBST(getBST()));
    }

    static boolean isBST(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.left.key > root.key)
            return false;

        if(root.right != null && root.right.key < root.key)
            return false;

        return isBST(root.left) && isBST(root.right);
    }
}
