package ds.LinkedList;

public class SinglelyLinkedList {

    public Node root;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }


    public void append(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = root;
        root = temp;
    }

    private void removeFromStart() {
        root = root.next;
    }

    private void removeFromEnd() {
        if (root == null || root.next == null) {
            root = null;
            return;
        }

        Node temp = root;
        Node prev = temp;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    public void print() {
        Node temp = root;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int length() {
        return length(root);
    }

    private int length(Node root) {
        if(root == null)
            return 0;

        return length(root.next) + 1;
    }

    public static void main(String[] args) {
        SinglelyLinkedList linkedList = new SinglelyLinkedList();
        linkedList.insert(12);
        linkedList.insert(13);
        linkedList.insert(14);
        linkedList.insert(15);
        linkedList.insert(16);
        linkedList.append(17);

        linkedList.removeFromEnd();
        linkedList.removeFromStart();
        linkedList.print();

        System.out.println("Length : " + linkedList.length());
    }
}
