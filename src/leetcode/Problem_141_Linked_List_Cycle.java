package leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Problem_141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast && (fast != null && fast.next != null)){
            slow = slow.next;
            fast=fast.next.next;
        }
        if(fast == null || fast.next == null){ return false; }
        return true;
    }
}