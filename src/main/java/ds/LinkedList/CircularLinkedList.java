package ds.LinkedList;

public class CircularLinkedList {
    Node last;

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

    public void insertAtStart(int data) {
        if (last == null) {
            last = new Node(data);
            last.next = last;
            return;
        }

        Node node = new Node(data);

        node.next = last.next;
        last.next = node;
    }
    //                       70 \
    // 14 -> 13 -> 45 -> 12 /   14 ..
    public void insertAtEnd(int data) {
        if (last == null) {
            last = new Node(data);
            last.next = last;
            return;
        }

        Node node = new Node(data);

        //   /70\
        // 12    12 ..
        node.next = last.next;
        last.next = node;
        last = last.next;
    }

    public void insertBetween(int afterNodeData, int data) {
        Node temp = last;
        Node node = new Node(data);

        temp = temp.next;

        while (temp != last) {
            if (temp.data == afterNodeData) {
                break;
            }
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
    }

    public void print() {
        Node temp = last;
        System.out.println("Last: " + last);
        temp = temp.next;

        while (temp != last) {
            System.out.print(temp + " -> ");
            temp = temp.next;
        }

        System.out.print(last);
    }

    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.insertAtStart(12);
        linkedList.insertAtStart(13);
        linkedList.insertAtStart(14);
        linkedList.insertBetween(13, 45);
        linkedList.insertAtEnd(70);
        linkedList.insertAtEnd(80);
        linkedList.insertAtEnd(90);

        linkedList.insertAtEnd(14);
        linkedList.print();
    }
}
