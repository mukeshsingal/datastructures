package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = pre;

        ListNode ds=head, de=head;
        while(de!=null) {
            if(de.next !=null && de.val == de.next.val) {
                de = de.next;
                continue;
            }

            if(ds != de) {
                pre.next = de.next;
                de.next = null;
                ds = de = pre.next;
            }
            else{
                pre=pre.next;
                ds = ds.next;
                de=de.next;
            }
        }
        return temp.next;
    }
}