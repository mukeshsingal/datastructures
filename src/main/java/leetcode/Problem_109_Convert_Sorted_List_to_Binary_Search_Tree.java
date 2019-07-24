package leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Problem_109_Convert_Sorted_List_to_Binary_Search_Tree {

    private ListNode findMiddleElement(ListNode head) {
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        //Iterate until fastPtr doesn't reach the end of the linked list.
        while(fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        //Handling the case when slow pointer is head
        if(prevPtr != null) {
            prevPtr.next = null;
        }
        return slowPtr;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode mid = this.findMiddleElement(head);

        TreeNode node = new TreeNode(mid.val);

        //Base case when just only left in linked list
        if(head == mid) {
            return node;
        }

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
}


// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         if(nums.length == 0) return null;
//         return DFS(nums, 0, nums.length- 1 );
//     }

//     private TreeNode DFS(int[] nums, int low, int high) {
//         int mid = (low + high)/2;
//         TreeNode root = new TreeNode(nums[mid]);
//         if(low <= mid -1)
//             root.left = DFS(nums, low, mid - 1);
//         if(mid + 1 <= high)
//             root.right = DFS(nums, mid + 1, high);
//         return root;
//     }
// }