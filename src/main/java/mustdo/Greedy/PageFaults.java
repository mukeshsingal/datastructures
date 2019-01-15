package mustdo.Greedy;

public class PageFaults {
    Node head;
    int pageFaults = 0;
    int memorySize = 0;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        PageFaults faults = new PageFaults();
        faults.memorySize = 4;
        faults.pageFaults = faults.memorySize;

        int[] arr = {3,1,0,2,5,4,1,2};

        for (int i = 0; i < faults.memorySize; i++) {
            faults.insert(arr[i]);
        }

        for (int i = faults.memorySize; i < arr.length; i++) {
            faults.pageFaults += faults.returnIfPageFault(arr[i]);
        }

        System.out.println("Total page faults " + faults.pageFaults);

    }

    int returnIfPageFault(int data) {
        Node temp = head;
        while (temp.next != null) {
            if(temp.data == data)
                return 0;
            temp = temp.next;
        }

        if(temp.data == data) {
            return 0;
        }
        else {
            head = head.next;
            temp.next = new Node(data);
            return 1;
        }
    }

    void insert(int data) {
        if(head == null) {
            head = new Node(data);
        }
        else {
            Node temp = head;
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }
}

