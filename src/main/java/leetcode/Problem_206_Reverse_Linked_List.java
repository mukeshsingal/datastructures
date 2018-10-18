package leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return node;
    }
}

