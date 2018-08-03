package geeksforgeeks.problems.Tree.Traversal;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

public class LevelOrderTraversal {

    public static void levelOrderTraversal(MyBinaryTree.Node root) {
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(10);
        if (root == null) {
            System.out.println("There is no node present in tree");
        } else {
            System.out.println("\nLevel Order Traversal");
            queue.enQueue(root);
            while (!queue.isEmpty()){
                MyBinaryTree.Node node = queue.deQueue();
                System.out.print (node.key + " ");
                if(node.left !=null )
                    queue.enQueue(node.left);
                if(node.right!=null)
                    queue.enQueue(node.right);
            }
        }

    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.right.left = new MyBinaryTree.Node(5);

        levelOrderTraversal(tree.root);
    }
}
