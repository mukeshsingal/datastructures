package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem49_Print_Ancestors_of_a_given_node_in_Binary_Tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        printAncestors(getBinaryTree2(), 7);
    }

    public static void printAncestors(Node<Integer> root, int key) {
        printAncestor(root, key);
    }

    public static boolean printAncestor(Node<Integer> root, int key) {
        if (root == null)
            return false;

        if (root.key == key) {
            System.out.println(root);
            return true;
        }

        if (printAncestor(root.left, key) || printAncestor(root.right, key)) {
            System.out.println(root);
            return true;
        }

        return false;
    }
}

