package leetcode;

public class LinkedList {

}

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * Given head which is a reference node to a singly-linked list. 
 * The value of each node in the linked list is either 0 or 1. 
 * The linked list holds the binary representation of a number. 
 * Return the decimal value of the number in the linked list.
 */
class Solution1290 {
    
    /* count helps in tracking postion from the last, when we return from recusion */
    int count = 0;

    public int getDecimalValue(ListNode head) {
        if(head == null)  return 0;
        
        int val = getDecimalValue(head.next);
        
        /* We need to just increment result with pow(2, count) if head contains 1 */
        val += head.val == 0 ? 0 : (int)Math.pow(2, count);
        count++;
        return val;
    }
}

/**
 * 876. Middle of the Linked List
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list. 
 * If there are two middle nodes, return the second middle node.
 */
class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}