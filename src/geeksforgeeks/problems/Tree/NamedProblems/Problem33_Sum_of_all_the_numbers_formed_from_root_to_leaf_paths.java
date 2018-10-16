package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem33_Sum_of_all_the_numbers_formed_from_root_to_leaf_paths extends BinaryTreeUtil {

    public static void main(String[] args) {
        Node<Integer> node = getBinaryTree();

        System.out.println(sumOfAllPaths(0, node));
    }

    public static int sumOfAllPaths(int sum, Node<Integer> node) {

        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return sum + node.key;

        int currentSum = node.key + sum;

        return sumOfAllPaths(currentSum, node.left) + sumOfAllPaths(currentSum, node.right);
    }
}

