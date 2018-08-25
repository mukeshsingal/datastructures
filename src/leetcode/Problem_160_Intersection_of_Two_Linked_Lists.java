package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Problem_160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //calculate length of list1
        int l1 = lengthOfList(headA);
        int l2 = lengthOfList(headB);

        if(l1 > l2){
            for(int i=0; i<l1-l2; i++) {
                headA = headA.next;
            }

        }
        if(l1 < l2){
            for(int i=0; i<l2-l1; i++) {
                headB = headB.next;
            }
        }
        while(headA != null){
            if(headA.val == headB.val){
                return headA;
            }
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public int lengthOfList(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}