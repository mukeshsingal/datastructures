package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_876_Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head.next == null){
            return head;
        }
        else {
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
