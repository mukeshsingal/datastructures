package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

/**
 * 2          2         4
 * /    +    / \   =   / \
 * 1        1   3     2   3
 */
public class Problem43_Merge_Two_Binary_Trees_by_doing_Node_Sum_Recursive extends BinaryTreeUtil {
    public static void main(String[] args) {
        levelOrderTraversal(mergeBinaryTreesBySum(getBinaryTree(), getBinaryTree2()));
    }

    static Node mergeBinaryTreesBySum(Node<Integer> root1, Node<Integer> root2) {

        if (root1== null) return root2;
        if (root2 == null) return root1;

        root1.key += root2.key;

        root1.left = mergeBinaryTreesBySum(root1.left, root2.left);
        root1.right = mergeBinaryTreesBySum(root1.right, root2.right);

        return root1;
    }
}
