package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem44_Foldable_Binary_Trees extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node node = getBinaryTree();

        //Here tree will be foldable if left and right subtree are same in structure
        System.out.println("Tree is " + (isFoldable(node.left, node.right) ? "Foldable" : "Not Foldable"));
    }

    static boolean isFoldable(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return isFoldable(root1.left, root2.right) && isFoldable(root1.right, root2.left);
    }
}
