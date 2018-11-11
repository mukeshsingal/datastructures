package ds.LinkedList;

public class DoublyLinkedList {
    Node head;

    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node node = new Node(data);
        node.next = head;
        head.prev = node;

        head = node;
    }

    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            return;
        }

        if (prevNode.next == null)
            append(data);

        Node node = new Node(data);
        node.next = prevNode.next;
        prevNode.next = node;
        node.next.prev = node;
        node.prev = prevNode;
    }

    public void insertBefore(Node nextNode, int data) {
        if (nextNode == null) {
            return;
        }

        if (nextNode.prev == null)
            insert(data);

        Node node = new Node(data);

        node.prev = nextNode.prev;
        node.prev.next = node;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node node = new Node(data);

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
        node.prev = temp;
    }

    public void print() {
        if (head == null) {
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp + " - > ");
            temp = temp.next;
        }
        System.out.print(" null");
    }

    public Node getNode(int data) {
        Node temp = head;
        while (temp != null) {
            if(temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(6);
        doublyLinkedList.insert(7);
        doublyLinkedList.append(12);
        doublyLinkedList.append(19);

        Node node  = doublyLinkedList.getNode(12);
        doublyLinkedList.insertAfter(node, 32);
        doublyLinkedList.insertBefore(node, 23);
        doublyLinkedList.print();
    }
}
