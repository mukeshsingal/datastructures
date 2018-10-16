package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem29_MirrorOfBinaryTree {
    public static void main(String[] args) {
        MyBinaryTree.Node root = BinaryTreeUtil.getBinaryTree();
        BinaryTreeUtil.levelOrderTraversal(root);

        MyBinaryTree.Node mirrorRoot = getMirror(root);
        BinaryTreeUtil.levelOrderTraversal(mirrorRoot);
    }

    public static MyBinaryTree.Node getMirror(MyBinaryTree.Node root) {
        if(root == null){
            return null;
        }
        else{
            MyBinaryTree.Node temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;

            getMirror(root.left);
            getMirror(root.right);

            return root;
        }
    }
}
