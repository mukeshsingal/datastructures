package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem48_Find_distance_from_root_to_given_node_in_a_binary_tree extends BinaryTreeUtil {
    public static void main(String[] args) {
        System.out.println(findDistance(getBinaryTree2(), 7, 0));
    }

    static int findDistance(Node<Integer> root, int key, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.key == key) {
            return distance;
        }
        int x = findDistance(root.left, key, distance + 1);
        if (x != -1) return x;
        return findDistance(root.right, key, distance + 1);
    }
}
