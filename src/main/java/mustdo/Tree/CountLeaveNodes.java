package mustdo.Tree;


public class CountLeaveNodes extends TreeUtil{
    public static void main(String[] args) {
        System.out.println("Leaves " + getLeaveCount(getBinaryTree2()));
    }
    public static int getLeaveCount(Node node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        return getLeaveCount(node.left) + getLeaveCount(node.right);
    }
}
