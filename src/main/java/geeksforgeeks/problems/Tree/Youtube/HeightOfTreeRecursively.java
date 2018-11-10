package geeksforgeeks.problems.Tree.Youtube;

import ds.trees.MyBinaryTree;

/**
 * Thre are two conventions to define height of binary tree.
 *
 * 1) Number of nodes on longest path from root to deepest node
 * 2) Number of edges on longest Path from root to the deepest node
 *          1
 *         / \
 *        2   3
 *       / \
 *      4  5   Ans: 3  : 1-2-4
 *
 * */
public class HeightOfTreeRecursively {

    public static int getHeight(MyBinaryTree.Node root){
        if(root == null) {
            return 0;
        }
        else{
            return Math.max(getHeight(root.left) + 1, getHeight(root.right)+1);
        }
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>(2);
        tree.root.left = new MyBinaryTree.Node(7);
        tree.root.right = new MyBinaryTree.Node(5);
        tree.root.left.right = new MyBinaryTree.Node(6);
        tree.root.left.right.left = new MyBinaryTree.Node(1);
        tree.root.left.right.right = new MyBinaryTree.Node(11);
        tree.root.right.right.left = new MyBinaryTree.Node(4);
        tree.root.right.right = new MyBinaryTree.Node(9);

        System.out.println("Height of Tree is " + getHeight(tree.root));

        /**
         *                    2
         *                 /    \
         *               7        5
         *               \          \
         *                6           9
         *               /  \         /
         *              1   11       4
         *
         * So height is : 4
         * */

    }
}
