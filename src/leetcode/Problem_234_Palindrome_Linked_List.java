package leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem_234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode list = new ListNode(0);
        ListNode temp;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            temp = slow.next;
            slow.next = list;
            list = slow;
            slow = temp;
        }
        if(fast!=null) {slow=slow.next;}
        while(list.next != null && slow !=null){
            if(slow.val != list.val){
                return false;
            }
            list = list.next;
            slow=slow.next;
        }
        return true;
    }
}