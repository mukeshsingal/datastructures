package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.Traversal.BinaryTreeUtil;

public class Problem32_LevelOrderTraversalInSpiralForm extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node root = getBinaryTree();
        levelOrderTraversalWithDirectionChangeAfterEachLevel(2, root);
    }
}
