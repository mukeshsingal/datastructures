package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);
        ListNode res = result;

        if(head1 == null) { return head2; };
        if(head2 == null) { return head1; };

        while(head1 !=null || head2 != null){
            if(head1 == null ) { result.next = head2; break;}
            if(head2 == null ) { result.next = head1; break;}

            if(head1.val <= head2.val){
                result.next = head1;
                head1 = head1.next;
            }
            else{
                result.next = head2;
                head2 = head2.next;
            }
            result = result.next;

        }
        return res.next;
    }
}
