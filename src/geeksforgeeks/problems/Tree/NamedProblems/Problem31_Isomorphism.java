package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

/**
 * Two trees are called isomorphic if one can be obtained from other by series of flips.
 * <p>
 * URL: https://youtu.be/8PDbyZ5VPZU?list=PLqM7alHXFySHCXD7r1J0ky9Zg_GBB1dbk
 */
public class Problem31_Isomorphism extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node rootOfTree1 = getBinaryTree();
        Node rootOfTree2 = getBinaryTree();

        System.out.println(isIsomorphic(rootOfTree1, rootOfTree2));

    }

    public static boolean isIsomorphic(Node rootOfTree1, Node rootOfTree2) {
        if (rootOfTree1 == null && rootOfTree2 == null) return true;

        if (rootOfTree1 == null || rootOfTree2 == null) return false;

        if (rootOfTree1.key != rootOfTree2.key) return false;

        return (isIsomorphic(rootOfTree1.left, rootOfTree2.left) &&
                isIsomorphic(rootOfTree1.right, rootOfTree2.right)) ||
                (isIsomorphic(rootOfTree1.left, rootOfTree2.right) &&
                        isIsomorphic(rootOfTree1.right, rootOfTree2.left));
    }
}
