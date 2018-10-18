package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        if(node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}