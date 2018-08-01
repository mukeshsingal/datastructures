package geeksforgeeks.ds;

public class MyLinkedList<T> {

    Node head;

    MyLinkedList(T key) {
        head = new Node(key);
    }

    MyLinkedList() {
        head = null;
    }

    public void addToStart(T key) {
        Node<T> newNode = new Node<>(key);
        newNode.next = head;
        head = newNode;
        System.out.println(key + " : Added at Start ");
    }
    public T removeFromStart() {
        if(head == null)
        {
            System.out.println(":LinkedList is already null");
            return null;
        }
        else{
            T key = (T) head.key;
            head= head.next;

            System.out.println(key + " : Removed from Start ");
            return key;
        }
    }

    public void addToEnd(T key) {

        if (head != null) {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(key);
        } else {
            head = new Node(key);
        }

        System.out.println(key + " : Added at End ");
    }

    public T removedFromEnd() {

        if(head == null){
            System.out.println(": LinkedList is already empty");
            return null;
        }
        else if(head.next == null){
            T key = (T) head.key;
            head = head.next;

            System.out.println(key + " : Removed from Head " );
            return key;
        }
        else{
            Node node = head;

            Node nextNode = node.next;

            while (nextNode.next != null) {
                node = node.next;
                nextNode = nextNode.next;
            }
            T key = (T) nextNode.key;
            node.next = null;
            System.out.println(key + " : Removed from End ");
            return key;
        }
    }

    public void addAfterIndex(int index, T key) {
        int tempIndex = index;
        Node tempNode = head;

        if (head != null) {
            while (tempIndex != 0 && tempNode.next != null) {
                tempNode = tempNode.next;
                tempIndex--;
            }
        }

        if (tempIndex == 0) {
            if (head == null) {
                head = new Node(key);
            } else {
                Node newNode = new Node(key);
                newNode.next = tempNode.next;
                tempNode.next = newNode;
            }
            System.out.println(key + " : Added after Index " + index);
        } else {
            System.out.println(": Index doesn't exist");
        }
    }


    public void print(Node head) {
        while (head != null) {
            System.out.print(head.key + " -> ");
            head = head.next;
        }
        System.out.print("null\n");
    }

    public class Node<T> {
        T key;
        Node next;

        Node(T key) {
            this.key = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToStart(2);
        list.addAfterIndex(0, 3);
        list.addToEnd(4);
        list.addAfterIndex(2, 7);
        list.removedFromEnd();
        list.print(list.head);
    }
}
