package leetcode;

public class Problem_707_Design_Linked_List {
}
class MyLinkedList {
    ListNode dummy;
    ListNode tail;
    int length;

    public MyLinkedList() {
        dummy = new ListNode(-1);
        tail = dummy;
        length = 0;
    }
    public int get(int index) {
        if (index == -1 || index >= length)
            return -1;
        ListNode ptr = dummy;
        while (index >= 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr.val;
    }

    public void addAtHead(int val) {
        ListNode head = new ListNode(val);
        head.next = dummy.next;
        dummy.next = head;
        length++;
        if (tail.next != null)
            tail = tail.next;
    }
    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        length++;
    }
    public void addAtIndex(int index, int val) {
        if (index > length)
            return;
        ListNode node = new ListNode(val);
        ListNode ptr = dummy;
        while (index > 0) {
            ptr = ptr.next;
            index--;
        }
        node.next = ptr.next;
        ptr.next = node;
        length++;
        if (tail.next != null)
            tail = tail.next;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length)
            return;
        ListNode ptr = dummy;
        while (index > 0) {
            ptr = ptr.next;
            index--;
        }
        if (ptr.next == tail)
            tail = ptr;
        ptr.next = ptr.next.next;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */