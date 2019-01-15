package mustdo.Tree;

public class HeightBalanced extends TreeUtil {
    public static void main(String[] args) {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        Height height = new Height();
        System.out.println("Height " + isBalanced(getBinaryTree2(), height));
    }

    static class Height {
        int height = 0;
    }

    static boolean isBalanced(Node root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lheight = new Height(), rheight = new Height();

        boolean isLeftBalanced = isBalanced(root.left, lheight);
        boolean isRightBalanced = isBalanced(root.right, rheight);

        int lh = lheight.height;
        int rh = rheight.height;
        height.height = Math.max(lh, rh) + 1;

        if (Math.abs(lh - rh) >= 2) {
            return false;
        }
        return isLeftBalanced && isRightBalanced;
    }
}
