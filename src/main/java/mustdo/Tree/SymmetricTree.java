package mustdo.Tree;

public class SymmetricTree extends TreeUtil{
    public static void main(String[] args) {
        System.out.println(isSymmetric(getSymmetricBinaryTree()));
    }

    private static boolean isSymmetric(Node binaryTree) {
        return checkIdentical(binaryTree, binaryTree);
    }

    public static boolean checkIdentical(Node node, Node node2) {
        if(node == null && node2 == null) {
            return true;
        }

        if((node == null && node2!= null )|| (node2 == null && node !=null)){
            return false;
        }
        return node.key == node2.key && checkIdentical(node.left, node2.right) && checkIdentical(node.right, node2.left);
    }


}
