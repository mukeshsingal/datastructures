package mustdo.Tree;

public class BinaryTreeToDLL extends TreeUtil {


    static Node prev = null;
    // head --> Pointer to head node of created doubly linked list
    Node head;

    // Driver program to test above functions
    public static void main(String[] args) {
        // Let us create the tree as shown in above diagram
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // convert to DLL
        BinaryTreeToDLL b2Dll = new BinaryTreeToDLL();
        b2Dll.covertToDLL(root);
        b2Dll.printList();
    }

    public void covertToDLL(Node root) {

        if (root == null)
            return;

        // Recursively convert left subtree
        covertToDLL(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        covertToDLL(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.key + " ");
            node = node.right;
        }
    }
}
