package mustdo.Tree;

public class BSTCheck extends TreeUtil{
    public static void main(String[] args) {
        System.out.println(isBst(getBST()));
    }

    static boolean isBst(Node root) {
        if(root == null) {
            return true;
        }
        if((root.left != null && root.key < root.left.key)){
            return false;
        }
        if(root.right != null && root.key > root.right.key) {
            return false;
        }
        return isBst(root.left) && isBst(root.right);
    }
}
