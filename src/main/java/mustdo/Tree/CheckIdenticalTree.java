package mustdo.Tree;

public class CheckIdenticalTree extends TreeUtil{
    public static void main(String[] args) {
        System.out.println(checkIdentical(getBinaryTree(), getBinaryTree()));
    }

    public static boolean checkIdentical(Node node, Node node2) {
        if(node == null && node2 == null) {
            return true;
        }

        if((node == null && node2!= null )|| (node2 == null && node !=null)){
            return false;
        }
        return node.key == node2.key && checkIdentical(node.left, node2.left) && checkIdentical(node.right, node2.right);
    }
}

