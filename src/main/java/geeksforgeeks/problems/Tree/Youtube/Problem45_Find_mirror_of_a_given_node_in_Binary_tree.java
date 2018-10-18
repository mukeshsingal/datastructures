package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem45_Find_mirror_of_a_given_node_in_Binary_tree extends BinaryTreeUtil {

    public static void main(String[] args) {
        Node node = getBinaryTree();
        Node result = mirrorOfNode(node, 5);
        System.out.println(result);
    }

    static Node mirrorOfNode(Node<Integer> node, int key) {
        if (node.key == key) {
            return node;
        }
        else {
            return mirrorOfNodeUtil(node.left, node.right, key);
        }
    }

    static Node mirrorOfNodeUtil(Node<Integer> node1, Node<Integer> node2, int key) {
        if(node1 == null || node2 == null ) return null;

        if(node1.key == key) return node2;
        if(node2.key == key) return node1;

        Node x = mirrorOfNodeUtil(node1.left, node2.right, key);
        if(x == null)
            return mirrorOfNodeUtil(node1.right, node2.left, key);
        return x;
    }
}
