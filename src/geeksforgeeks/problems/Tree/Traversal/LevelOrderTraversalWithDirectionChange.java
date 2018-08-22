package geeksforgeeks.problems.Tree.Traversal;

import geeksforgeeks.ds.MyBinaryTree;
import geeksforgeeks.ds.MyLinkedList;
import geeksforgeeks.ds.MyLinkedStack;
import geeksforgeeks.ds.MyQueue;

//after each two levels
public class LevelOrderTraversalWithDirectionChange {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.root = new MyBinaryTree.Node(1);
        tree.root.left = new MyBinaryTree.Node(2);
        tree.root.left.left = new MyBinaryTree.Node(4);
        tree.root.left.right = new MyBinaryTree.Node(5);
        tree.root.right = new MyBinaryTree.Node(3);
        tree.root.right.left = new MyBinaryTree.Node(6);
        tree.root.right.right = new MyBinaryTree.Node(7);

        //expected answer is 1, 2 3, 7 6 5 4

        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(20);
        MyLinkedStack<MyBinaryTree.Node> stack = new MyLinkedStack();

        int numberOfNodesAtLevel = 0, changeDirectionCount = 0;
        boolean rightToLeft = false;

        queue.enQueue(tree.root);
        while (!queue.isEmpty()) {
            changeDirectionCount++;
            numberOfNodesAtLevel = queue.size();

            for(int i=0; i<numberOfNodesAtLevel; i++) {
                MyBinaryTree.Node temp = queue.deQueue();

                if(rightToLeft == false)
                    System.out.print(temp.key + " ");
                else
                    stack.push(temp);

                if (temp.left != null) {
                    queue.enQueue(temp.left);
                }
                if (temp.right != null) {
                    queue.enQueue(temp.right);
                }
            }

            if(rightToLeft == true){
                while (!stack.isEmpty()) {
                    MyBinaryTree.Node  temp = stack.pop();
                    System.out.print(temp.key + " ");
                }
            }

            if(changeDirectionCount == 2){
                changeDirectionCount = 0;
                rightToLeft = !rightToLeft;
            }
            System.out.println();
        }


    }
}
