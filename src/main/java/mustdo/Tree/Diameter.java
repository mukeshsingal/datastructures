package mustdo.Tree;

public class Diameter extends TreeUtil{
    public static void main(String[] args) {
        Res result = new Res();
        result.val= Integer.MIN_VALUE;
        getDiameterLength(getBinaryTree2(), result);
        System.out.println("Diameter is " + result.val);

    }
    static class Res {
        int val;
    }

    private static int getDiameterLength(Node root, Res result) {
        if(root == null ) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int l = getDiameterLength(root.left, result);
        int r = getDiameterLength(root.right, result);
        result.val = Math.max(result.val, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
