package leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_203_Remove_Linked_List_Elements  {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode temp = prev;
        ListNode x;
        ListNode current = head;

        while(current != null){
            if(current.val == val) {
                prev.next = current.next;
                x = current.next;
                current.next = null;
                current = x;

            }
            else{
                prev = current;
                current = current.next;
            }
        }

        return temp.next;
    }
}
