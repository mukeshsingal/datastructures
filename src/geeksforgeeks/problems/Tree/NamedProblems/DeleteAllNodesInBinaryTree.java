package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

public class DeleteAllNodesInBinaryTree {

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>(2);
        tree.root.left = new MyBinaryTree.Node(7);
        tree.root.right = new MyBinaryTree.Node(5);
        tree.root.left.right = new MyBinaryTree.Node(6);
        tree.root.left.right.left = new MyBinaryTree.Node(1);
        tree.root.left.right.right = new MyBinaryTree.Node(11);
        tree.root.right.right = new MyBinaryTree.Node(9);
        tree.root.right.right.left = new MyBinaryTree.Node(4);
        deleteTree(tree);

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

    private static void deleteTree(MyBinaryTree tree) {
        tree.root = null;
        if(tree.root == null){
            System.out.println("All the nodes has been deleted");
        }
        else{
            System.out.println("Failed to delete all nodes in java");
        }
    }
}