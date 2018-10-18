package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem57_Check_if_leaf_traversal_of_two_Binary_Trees_is_same extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(isSame(getBinaryTree(), getBinaryTree2()));
    }


    public static boolean isSame(Node root, Node root2) {
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Node> leaves = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (isLeaf(node)) leaves.add(node);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        queue.add(root2);

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (isLeaf(node))
                if (leaves.remove().key != node.key) {
                    return false;
                }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return true;
    }

    public static boolean isLeaf(Node root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }
}

