package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem54_Check_for_Children_Sum_Property_in_a_Binary_Tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(checkChildrenSumProperty(getBinaryTree()));
    }

    static boolean checkChildrenSumProperty(Node<Integer> node) {
        int lsum = 0, rsum = 0;
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        if (node.left != null)
            lsum = (int) node.left.key;

        if (node.right != null)
            rsum = (int) node.right.key;

        return (node.key == lsum + rsum) && checkChildrenSumProperty(node.left) && checkChildrenSumProperty(node.right);
    }
}
