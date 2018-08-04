package geeksforgeeks.problems.Tree.NamedProblems;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyQueue;

public class CheckTwoTreesAreIdentical {

    public static boolean isIdentical(MyBinaryTree tree1, MyBinaryTree tree2) {
        if (tree1 == null ^ tree2 == null) {
            return false;
        }

        MyQueue<MyBinaryTree.Node> queue1 = new MyQueue<>(20);
        MyQueue<MyBinaryTree.Node> queue2 = new MyQueue<>(20);

        queue1.enQueue(tree1.root);
        queue2.enQueue(tree2.root);

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            MyBinaryTree.Node node1 = queue1.deQueue();
            MyBinaryTree.Node node2 = queue2.deQueue();

            if (node1.key != node2.key){
                return false;
            }

            if((checkForNull(node1.left) && checkForNull(node2.left))){
                queue1.enQueue(node1.left);
                queue2.enQueue(node2.left);
            }
            else if(checkForNull(node1.left) || checkForNull(node2.left)){
                return false;
            }
            if((checkForNull(node1.right) && checkForNull(node2.right))){
                queue1.enQueue(node1.right);
                queue2.enQueue(node2.right);
            }
            else if(checkForNull(node1.right) || checkForNull(node2.right)){
                return false;
            }

        }

        return true;
    }

    public static boolean checkForNull(Object object){
        return object != null;
    }


    public static void main(String[] args) {
        MyBinaryTree<Integer> tree1 = new MyBinaryTree<>(2);
        tree1.root.left = new MyBinaryTree.Node(7);
        tree1.root.right = new MyBinaryTree.Node(5);
        tree1.root.left.right = new MyBinaryTree.Node(6);
        tree1.root.left.right.left = new MyBinaryTree.Node(1);
        tree1.root.left.right.right = new MyBinaryTree.Node(11);
        tree1.root.right.right = new MyBinaryTree.Node(9);
        tree1.root.right.right.left = new MyBinaryTree.Node(4);

        MyBinaryTree<Integer> tree2 = new MyBinaryTree<>(2);
        tree2.root.left = new MyBinaryTree.Node(7);
        tree2.root.right = new MyBinaryTree.Node(5);
        tree2.root.left.right = new MyBinaryTree.Node(6);
        tree2.root.left.right.left = new MyBinaryTree.Node(1);
        tree2.root.left.right.right = new MyBinaryTree.Node(11);
        tree2.root.right.right = new MyBinaryTree.Node(9);
        tree2.root.right.right.left = new MyBinaryTree.Node(4);


        if (isIdentical(tree1, tree2)) {
            System.out.println("Tree are identical");
        } else {
            System.out.println("Tree aren't identical");
        }
    }
}
