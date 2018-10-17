package geeksforgeeks.problems.Tree.Youtube;

import geeksforgeeks.problems.Tree.BinaryTreeUtil;

public class Problem46_Extract_Leaves_of_a_Binary_Tree_in_a_Doubly_Linked_List extends BinaryTreeUtil {
    public static void main(String[] args) {
        Node node = extractLeavesInDoublyLinkedList(getBinaryTree2(), null);
        printDoublyList(node);
    }

    public static void printDoublyList(Node node) {
        if(node == null) return;
        System.out.println(node);
        printDoublyList(node.right);
    }

    /* Here left -> prev and right -> next pointer */
    static Node extractLeavesInDoublyLinkedList(Node root, Node doublyHead) {
        if (root == null)
            return doublyHead;

        if (root.left == null && root.right == null) {
            root.right = doublyHead;
            if (doublyHead != null)
                doublyHead.left = root;
            doublyHead = root;
            return doublyHead;
        }

        doublyHead = extractLeavesInDoublyLinkedList(root.right, doublyHead);
        doublyHead = extractLeavesInDoublyLinkedList(root.left, doublyHead);

        return doublyHead;
    }
}

