package geeksforgeeks.problems.Tree.Youtube;

import ds.trees.MyBinaryTree;
import ds.Queue.MyQueue;

public class Sorted_Array_to_Balanced_BST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        MyBinaryTree.Node root = getBalancedTree(arr, 0, arr.length - 1);
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(10);
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            MyBinaryTree.Node node = queue.deQueue();
            System.out.println(node.key);
            if (node.left != null)
                queue.enQueue(node.left);
            if (node.right != null)
                queue.enQueue(node.right);
        }
    }

    public static MyBinaryTree.Node<Integer> getBalancedTree(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        MyBinaryTree.Node root = new MyBinaryTree.Node(arr[mid]);

        root.left = getBalancedTree(arr, start, mid - 1);
        root.right = getBalancedTree(arr, mid + 1, end);

        return root;
    }
}
