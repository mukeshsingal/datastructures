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
    
    /**/
    int count = 0;
    public int getDecimalValue(ListNode head) {
        if(head == null)  return 0;
        
        int val = getDecimalValue(head.next);
        
        val += head.val == 0 ? 0 : (int)Math.pow(2, count);
        
        count++;
        
        return val;
    }
}