package ds.LinkedList.gfg;

public class SwapNodesInLinkedList {
    Node head;

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

    public void add(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }

        node.next = head;
        head = node;
    }

    /**
     * Corner cases
     * 1. Either one of them is not present
     * 2. node 1 is head node
     * 3. Node 3 is last node
     * 4. Nodes are in mid of LinkedList
     */
    public void swap(int x, int y) {
        if (x == y) return;

        Node prevX = null, prevY = null, currentX = head, currentY = head;

        while (currentY != null && currentY.data != y) {
            prevY = currentY;
            currentY = currentY.next;
        }

        while (currentX != null && currentX.data != x) {
            prevX = currentX;
            currentX = currentX.next;
        }

        if (currentX == null || currentY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = currentY;
        } else {
            head = currentY;
        }

        if (prevY != null) {
            prevY.next = currentX;
        } else {
            head = currentX;
        }

        /*Swap the Nodes*/
        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp + " -> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SwapNodesInLinkedList linkedList = new SwapNodesInLinkedList();
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);
        linkedList.add(15);
        linkedList.add(16);
        linkedList.swap(15, 13);
        linkedList.print();
    }
}
