package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_83_Remove_Duplicates_from_Sorted_List  {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next != null && head.val == head.next.val){
            head.next = head.next.next;
            deleteDuplicates(head);
        }
        else{
            deleteDuplicates(head.next);
        }


        return head;
    }
}