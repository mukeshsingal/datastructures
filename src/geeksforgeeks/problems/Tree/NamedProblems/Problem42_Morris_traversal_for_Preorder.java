package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem42_Morris_traversal_for_Preorder extends BinaryTreeUtil {
    public static void main(String[] args) {
        preOrderTraversal(getBinaryTree());
        System.out.println();
        morrisTraversalPreOrder(getBinaryTree());
    }

    public static void morrisTraversalPreOrder(Node root) {

        while (root != null) {

            /*NLR: in case left is null, print current node and move to right*/
            if (root.left == null) {
                System.out.print(root.key + " ");
                root = root.right;
            } else {
                //Find inOrder predecessor
                Node current = root.left;
                while (current.right != null && current.right != root) {
                    current = current.right;
                }

                //if right child of predecessor is already pointing to this node
                if (current.right == root) {
                    current.right = null;
                    root = root.right;
                }
                else {
                    System.out.print(root.key + " ");
                    current.right = root;
                    root = root.left;
                }
            }
        }
    }
}
