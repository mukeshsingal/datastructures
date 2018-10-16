package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem29_MirrorOfBinaryTree extends BinaryTreeUtil {

    public static void main(String[] args) {
        Node root = getBinaryTree();
        levelOrderTraversal(root);

        Node mirrorRoot = getMirror(root);
        levelOrderTraversal(mirrorRoot);
    }

    public static Node getMirror(Node root) {
        if (root == null) {
            return null;
        } else {
            Node temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;

            getMirror(root.left);
            getMirror(root.right);

            return root;
        }
    }
}
